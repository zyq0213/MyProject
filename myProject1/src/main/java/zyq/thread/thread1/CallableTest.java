package zyq.thread.thread1;


import com.sun.org.apache.xpath.internal.operations.String;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author yanqing.zou
 * @date 2022-07-21 11:33
 * Description
 */
public class CallableTest {

    public static void main(String[] args) {
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int sum = 0;
                for (int i = 0; i <= 1000; i++) {
                    sum += i;
                }
                return sum;
            }
        };
        //为了让线程执行 callable 中的任务，光使用构造方法还不够，需要一个辅助的类。
        //通过 FutureTask 来作为中转
        FutureTask<Integer> task = new FutureTask<>(callable);
        //创建线程，来完成这里的工作
        Thread t = new Thread(task);
        t.start();
        //相当于运行任务的时候，有阻塞情况，要等到阻塞之后，运行完之后就可以输出了
        try {
            System.out.println(task.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (
                ExecutionException e) {
            e.printStackTrace();
        }
    }
}
