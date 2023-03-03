package zyq.A_normal.schedule;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author yanqing.zou
 * @date 2022-11-22 14:56
 * Description
 */
public class Test1 {

    private static ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(8,new ThreadFactoryBuilder()
            .setNameFormat("demo-pool-%d").build());

    public static void test1(){
        scheduledExecutorService.schedule(() ->{
            System.out.println("test time");
        },3, TimeUnit.SECONDS);
    }

    public static void main(String[] args) {
        test1();
    }
}
