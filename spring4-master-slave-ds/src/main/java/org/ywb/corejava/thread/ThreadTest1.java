package org.ywb.corejava.thread;

/**
 * User: yangwenbiao
 * Date: 2017/3/31
 * Time: 10:00
 * <p>
 * 编写两个线程，一个线程打印1~25，另一个线程打印字母A~Z，打印顺序为12A34B56C……5152Z，要求使用线程间的通信。
 */
public class ThreadTest1 {

    protected static Object lock = new Object();
    protected static int flag = 0;
    protected static String[] getString() {
        String[] ss = new String[26];
        char a = 'A';
        for (int i = 0; i < 26; i++) {
            ss[i] = Character.toString(a);
            a++;
        }
        return ss;
    }

    public static void main(String[] args) {
        new Thread(new NumTask(), "num").start();
        new Thread(new StringTask(), "string").start();
    }


    static class NumTask implements Runnable {

        @Override
        public void run() {

            for (int i = 1; i <= 52; i+=2) {
                try {
                    synchronized (lock) {
                        if (flag == 2) {
                            lock.wait();
                        }

                        System.out.print(i);
                        System.out.print(i+1);
                        flag = 2;
                        lock.notify();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    static class StringTask implements Runnable {
        private final String[] ss = getString();

        @Override
        public void run() {

            for (String s : ss) {
                try {
                    synchronized (lock) {
                        if (flag == 1) {
                            lock.wait();
                        }
                        System.out.print(s);
                        flag = 1;
                        lock.notify();

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
