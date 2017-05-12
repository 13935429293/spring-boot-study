package org.ywb.corejava.thread;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * User: yangwenbiao
 * Date: 2017/3/8
 * Time: 19:01
 */
public class Depercated {

    public static void main(String[] args) throws Exception {
        DateFormat df = new SimpleDateFormat("HH:mm:ss");
        Thread printThread = new Thread(new Runner(), "PrintThread");
        printThread.setDaemon(true);
        printThread.start();

        TimeUnit.SECONDS.sleep(3);

        printThread.suspend();//暂停


    }

    static class Runner implements Runnable{

        @Override
        public void run() {
            DateFormat df = new SimpleDateFormat("HH:mm:ss");
            while (true) {
                System.out.println(Thread.currentThread().getName() + " Run at " + df.format(new Date()));
                SleepUtils.second(1);
            }
        }
    }
}
