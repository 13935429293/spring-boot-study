package org.ywb.corejava.thread;

/**
 * User: yangwenbiao
 * Date: 2017/3/8
 * Time: 18:45
 */
public class Daemon {
    public static void main(String[] args) {
        Thread thread = new Thread(new DaemonRunner(), "DaemonRunner");
        thread.setDaemon(true);
        thread.start();
    }

    static class DaemonRunner implements Runnable{

        @Override
        public void run() {
            try {
                SleepUtils.second(100);
            } finally {
                System.out.println("DaemonRunner finally run.");
            }
        }
    }
}
