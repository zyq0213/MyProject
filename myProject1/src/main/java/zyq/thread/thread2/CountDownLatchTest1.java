package zyq.thread.thread2;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author yanqing.zou
 * @date 2023-05-24 15:01
 * Description
 */
public class CountDownLatchTest1 {

        public static void main(String[] args) {
            ExecutorService pool = Executors.newCachedThreadPool();
            CountDownLatch cdl = new CountDownLatch(100);
            for (int i = 0; i < 100; i++) {
                CountRunnable runnable = new CountRunnable(cdl);   // 设置CountRunnable类中countDownLatch变量的数据为100
                pool.execute(runnable);
            }
        }
    }

    class CountRunnable implements Runnable {
        private CountDownLatch countDownLatch;
        public CountRunnable(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }
        @Override
        public void run() {
            try {
                synchronized (countDownLatch) {
                    /*** 每次减少一个容量*/
                    countDownLatch.countDown();
                    System.out.println("thread counts = " + (countDownLatch.getCount()));
                }
                System.out.println("concurrency counts = " + (100 - countDownLatch.getCount()));
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


