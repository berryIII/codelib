package com.tanpp.common;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author tanpp
 */
public class Main2 {
    private static final ExecutorService ex = Executors.newFixedThreadPool(3);
    private static AtomicInteger a = new AtomicInteger(0);
    private static LinkedBlockingQueue<String> q = new LinkedBlockingQueue<>();

    public static void main(String[] args) throws InterruptedException {
        ex.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    while (a.intValue() < 300) {
                        int i = a.intValue();
                        if (a.compareAndSet(i, i + 1)) {
                            if (i % 3 == 0) {
                                q.put("A:" + i);
                            } else if (i % 3 == 1) {
                                q.put("B");
                            } else {
                                q.put("C");
                            }
                        }
                    }
                } catch (Exception ignored) {

                }

            }
        });

        ex.execute(new Runnable() {
            public void run() {
                try {
                    while (a.intValue() < 300) {
                        int i = a.intValue();
                        if (a.compareAndSet(i, i + 1)) {
                            if (i % 3 == 0) {
                                q.put("A:" + i);
                            } else if (i % 3 == 1) {
                                q.put("B");
                            } else {
                                q.put("C");
                            }
                        }
                    }
                } catch (Exception ignored) {

                }

            }
        });

        ex.execute(new Runnable() {
            public void run() {
                try {
                    while (a.intValue() < 300) {
                        int i = a.intValue();
                        if (a.compareAndSet(i, i + 1)) {
                            if (i % 3 == 0) {
                                q.put("A:" + i);
                            } else if (i % 3 == 1) {
                                q.put("B");
                            } else {
                                q.put("C");
                            }
                        }
                    }
                } catch (Exception ignored) {

                }

            }
        });

        long start = System.currentTimeMillis();
        ex.shutdown();
        ex.awaitTermination(10, TimeUnit.SECONDS);
        for(int i=0;i<300;i++){
            System.out.println(q.take());
        }
        //q.put(System.currentTimeMillis() - start);
        System.out.println(a.intValue());
    }
}
