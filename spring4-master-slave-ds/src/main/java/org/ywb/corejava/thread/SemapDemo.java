package org.ywb.corejava.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by Administrator on 2017/3/14.
 */
public class SemapDemo implements Runnable {
    Semaphore semp = new Semaphore(5);

    @Override
    public void run() {
        try {
            semp.acquire();
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getId() + " is done!");
            semp.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(10);
        SemapDemo demo = new SemapDemo();
        for (int i = 0; i < 100; i++) {
            pool.submit(demo);
        }
        pool.shutdown();
    }
}
