package zyq.basic_;

import java.util.concurrent.*;


public class ThreadLocalTest {
    private static final ExecutorService executorService = new ThreadPoolExecutor(8, 16, 60,
            TimeUnit.SECONDS, new LinkedBlockingQueue<>(1024),Executors.defaultThreadFactory());

    private static ExecutorService executorService1 = Executors.newFixedThreadPool(1);


    /**
     * 父子线程隔离
     */
    public static void test1(){
        ThreadLocal threadLocal = new ThreadLocal();

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                threadLocal.set("test111");
                System.out.println("父线程currentThread -" + Thread.currentThread().getName()+":"+threadLocal.get());
                executorService.execute(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("子线程currentThread -" + Thread.currentThread().getName()+":"+threadLocal.get());
                    }
                });

            }
        });
    }

    /**
     * 应该只是 不同线程隔离，应该ThreadLocal使用的是Thread.currentThread来作为key
     */
    public static void test2(){
        ThreadLocal threadLocal = new ThreadLocal();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal.set("test111");
                System.out.println("父线程currentThread -" + Thread.currentThread().getName() + ":" + threadLocal.get());
            }
        });
        t1.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("父线程currentThread -" + Thread.currentThread().getName()+":"+ threadLocal.get());
            }
        }).start();

    }

    /**
     * inheritableThreadLocal
     */
    public static void test3(){
        ThreadLocal threadLocal = new InheritableThreadLocal<>();
        new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal.set("test111");
                System.out.println("父线程currentThread -" + Thread.currentThread().getName()+":"+threadLocal.get());
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("子线程currentThread -" + Thread.currentThread().getName()+":"+threadLocal.get());
                    }
                }).start();

            }
        }).start();
    }

    public static void test4(){
        for(int i = 0; i < Integer.MAX_VALUE; i++) {
            System.out.println("塞任务start..." + i);
            Integer msg = i;
            executorService.execute(() -> {
                try {
                    //模拟 占用的内存大小
                    Byte[] bytes = new Byte[1024 * 1000 * 1000];
                    System.out.println(Thread.currentThread().getName() + "-->任务放到线程池:" + msg);
                    TimeUnit.MINUTES.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            System.out.println("塞任务end..." + i);
        }
    }


    /**
     * 线程池线程复用隔离
     */
    public static void test5(){
        ThreadLocal t1 = new ThreadLocal();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(()->{
            t1.set("test111");

            System.out.println("currentThread-"+Thread.currentThread().getName()+":"+t1.get());
        });
        executorService.execute(()->{
            System.out.println("currentThread-"+Thread.currentThread().getName()+":"+t1.get());
        });
        executorService.execute(()->{
            System.out.println("currentThread-"+Thread.currentThread().getName()+":"+t1.get());
        });
        executorService.execute(()->{
            System.out.println("currentThread-"+Thread.currentThread().getName()+":"+t1.get());
        });
        executorService.shutdown();
    }

    public static void test6(){
        ThreadLocal t1= new InheritableThreadLocal();
        new Thread(()->{
            t1.set("test111");
            System.out.println("---currentThread-"+Thread.currentThread().getName()+":"+t1.get());
            new Thread(()->{
                System.out.println("---currentThread-"+Thread.currentThread().getName()+":"+t1.get());
            }).start();
        }).start();

        new Thread(()->{
            System.out.println("currentThread-"+Thread.currentThread().getName()+":"+t1.get());
        }).start();

        new Thread(()->{
            System.out.println("currentThread-"+Thread.currentThread().getName()+":"+t1.get());
        }).start();

        new Thread(()->{
            System.out.println("currentThread-"+Thread.currentThread().getName()+":"+t1.get());
        }).start();



    }


    public static void main(String[] args) {
        test1();
    }
}
