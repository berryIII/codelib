package com.tanpp.common;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author tanpp
 */
public class Main {
    private static final ExecutorService ex = Executors.newFixedThreadPool(3);
    private static final Object lockA = new Object();
    private static final Object lockB = new Object();
    private static final Object lockC = new Object();

    public static void main(String[] args) throws InterruptedException {
        ex.execute(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    synchronized (lockA){
                        try {
                            lockA.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("A:"+i);
                        synchronized (lockB){
                            lockB.notifyAll();
                        }
                    }
                }
            }
        });

        ex.execute(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    synchronized (lockB){
                        try {
                            lockB.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("B");
                        synchronized (lockC){
                            lockC.notifyAll();
                        }
                    }
                }
            }
        });

        ex.execute(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    synchronized (lockC){
                        try {
                            lockC.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("C");
                        synchronized (lockA){
                            lockA.notifyAll();
                        }
                    }
                }
            }
        });

        long start = System.currentTimeMillis();
        synchronized (lockA){
            lockA.notifyAll(); // trigger
        }

        ex.shutdown();
        ex.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println(System.currentTimeMillis()-start);
    }
}
