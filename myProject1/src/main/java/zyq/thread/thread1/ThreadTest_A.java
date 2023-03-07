package zyq.thread.thread1;

import lombok.SneakyThrows;

/**
 * @author yanqing.zou
 * @date 2022-07-21 15:23
 * Description
 */
public class ThreadTest_A {


    int num = 10;

    public  void print1() throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+": **********");
        synchronized (new Object()) {
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName() + ": AAAAAAAAAAAAAAAA");
        }
    }
    public synchronized void print2() throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+": ###############");
        Thread.sleep(5000);
        System.out.println(Thread.currentThread().getName()+": BBBBBBBBBBBBB");

    }
    public static void main(String[] args){
        ThreadTest_A threadTest_A1 = new ThreadTest_A();
        ThreadTest_A threadTest_A2 = new ThreadTest_A();
        new Thread(new Runnable() {
           @SneakyThrows
           @Override
           public void run() {
               Thread.currentThread().setName("Thread1");
               threadTest_A1.print1();
           }
       },"Thread1").start();
        new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                Thread.currentThread().setName("Thread2");
                threadTest_A1.print1();
            }
        },"Thread2").start();

    }
}
