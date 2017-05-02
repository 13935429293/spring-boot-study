package org.ywb.study.ch3.nio;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * date: 2017/4/19 19:13
 * description:
 */
public class TimeClient {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 5000; i++) {
            executor.execute(new TimeClientHandler("127.0.0.1", 8888));
        }

        executor.shutdown();

        // Thread.sleep(Long.MAX_VALUE);
    }
}
