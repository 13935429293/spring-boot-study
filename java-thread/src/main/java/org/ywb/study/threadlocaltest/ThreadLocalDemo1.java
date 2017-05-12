package org.ywb.study.threadlocaltest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * date: 2017/5/2 15:57
 * description:
 */
public class ThreadLocalDemo1 {
    private static ThreadLocal<SimpleDateFormat> tl = new ThreadLocal<>();

    public static class ParseDate implements Runnable {

        int i = 0;

        public ParseDate(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            try {
                if (tl.get() == null) {
                    tl.set(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
                }

                Date d = tl.get().parse("2017-05-02 16:01:" + i % 60);
                System.out.println(i + ", " + d);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 1000; i++) {
            es.execute(new ParseDate(i));
        }
    }
}
