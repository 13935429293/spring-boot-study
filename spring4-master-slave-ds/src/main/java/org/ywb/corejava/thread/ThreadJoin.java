package org.ywb.corejava.thread;

import java.util.HashSet;

/**
 * User: yangwenbiao
 * Date: 2017/3/10
 * Time: 14:32
 */
public class ThreadJoin {

    public static void main(String[] args) {
        Thread prev = Thread.currentThread();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Domino(prev), String.valueOf(i));
            thread.start();
            prev = thread;
        }
        System.out.println(Thread.currentThread().getName() + " terminate.");

    }

    static class Domino implements Runnable{

        private Thread thread;

        public Domino(Thread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " terminate.");
        }
    }
}
