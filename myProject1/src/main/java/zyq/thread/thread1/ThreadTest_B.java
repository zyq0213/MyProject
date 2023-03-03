package zyq.thread.thread1;

import lombok.SneakyThrows;

/**
 * @author yanqing.zou
 * @date 2022-07-21 17:56
 * Description
 */
public class ThreadTest_B{

    Object lockA = new Object();
    Object lockB = new Object();

    public void print(Boolean b) throws InterruptedException {
        for(int i = 10 ;i>0; i--) {
            if (b) {
                synchronized (lockA) {
                    System.out.println(Thread.currentThread().getName()+": "+i);
                    Thread.sleep(3000);
                    synchronized (lockB){
                        System.out.println(Thread.currentThread().getName()+": "+i);
                    }
                }
            } else {
                synchronized (lockB) {
                    System.out.println(Thread.currentThread().getName()+": "+i);
                    synchronized (lockA){
                        System.out.println(Thread.currentThread().getName()+": "+i);
                    }
                }
            }
        }
    }

    public static void main(String[] args){
        ThreadTest_B threadTest_b1 = new ThreadTest_B();
        ThreadTest_B threadTest_b2 = new ThreadTest_B();

        new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                threadTest_b1.print(true);
            }
        },"Thread1").start();

        new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                threadTest_b2.print(false);
            }
        },"Thread2").start();

    }
}
