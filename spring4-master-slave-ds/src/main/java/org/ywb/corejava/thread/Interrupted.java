package org.ywb.corejava.thread;

import java.util.concurrent.TimeUnit;

/**
 * User: yangwenbiao
 * Date: 2017/3/8
 * Time: 18:51
 *
 * 抛出 InterruptException 之前，jvm会先将该线程中的中断位清除，然后抛出异常，此时调用isInterrupt()方法将放回false
 */
public class Interrupted {
    public static void main(String[] args) throws Exception {
        Thread sleepThread = new Thread(new SleepRunner(), "SleepRunner");
        sleepThread.setDaemon(true);
        Thread busyThread = new Thread(new BusyRunner(), "BusyRunner");
        busyThread.setDaemon(true);

        sleepThread.start();
        busyThread.start();

        TimeUnit.SECONDS.sleep(5);
        sleepThread.interrupt();
        busyThread.interrupt();
        System.out.println("SleepThread interrupt is " + sleepThread.isInterrupted());
        System.out.println("BusyThread interrupt is " + busyThread.isInterrupted());

        SleepUtils.second(2);
    }

    static class SleepRunner implements Runnable {

        @Override
        public void run() {
            while (true) {
                SleepUtils.second(10);
            }
        }
    }

    static class BusyRunner implements Runnable {

        @Override
        public void run() {
            while (true) {

            }
        }
    }
}
