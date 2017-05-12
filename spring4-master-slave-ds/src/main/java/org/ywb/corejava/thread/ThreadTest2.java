package org.ywb.corejava.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * User: yangwenbiao
 * Date: 2017/3/31
 * Time: 10:54
 */
public class ThreadTest2 {

    protected static ReentrantLock lock = new ReentrantLock(true);
    protected static Condition condition = lock.newCondition();
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

    static class NumTask implements Runnable{

        @Override
        public void run() {
            for (int i = 1; i <= 52; i+=2) {
                try {
                    lock.lock();
                    if (flag == 1)
                        condition.await();

                    System.out.print(i);
                    System.out.print(i+1);
                    flag = 1;
                    condition.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }

            }
        }
    }

    static class StringTask implements Runnable{

        private final String[] strs = getString();
        @Override
        public void run() {
            for (String str : strs) {
                try {
                    lock.lock();

                    if (flag == 2) {
                        condition.await();
                    }

                    System.out.print(str);
                    flag = 2;
                    condition.signal();

                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new NumTask()).start();
        new Thread(new StringTask()).start();
    }
}
