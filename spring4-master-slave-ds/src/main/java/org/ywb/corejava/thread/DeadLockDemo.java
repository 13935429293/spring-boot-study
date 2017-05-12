package org.ywb.corejava.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * User: yangwenbiao
 * Date: 2017/3/7
 * Time: 16:12
 */
public class DeadLockDemo {
    private static String A = "A";
    private static String B = "B";

    public static void main(String[] args) {
        new DeadLockDemo().deadLock();
    }

    private void deadLock(){
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (A) {
                    try {
                        Thread.currentThread().sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized (B) {
                        System.out.println(1);
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (B) {
                    synchronized (A) {
                        System.out.println(2);
                    }
                }
            }
        });

        t1.start();
        t2.start();
    }
}

/**
 * example 与 example1 是等价的
 * 对 volatile 变量的单个读写，看成是使用同一个锁对这些单个读写操作做了同步
 */
class VolatileFeaturesExample{
    volatile long v1 = 0L;

    public void getAndIncrment(){
        v1++;
    }

    public long get() {
        return v1;
    }

    public void set(long l) {
        this.v1 = l;
    }
}

class VolatileFeaturesExample1{
    long v1 = 0L;

    public void getAndIncrment(){
        long temp = get();
        temp += 1L;
        set(temp);
    }

    public synchronized long get() {
        return v1;
    }

    public synchronized void set(long l) {
        this.v1 = l;
    }
}

class ReentrantLockExample{

    ReentrantLock lock = new ReentrantLock();
    int a = 0;
    public void writer(){
        lock.lock();

        try {
            a++;
        } finally {
            lock.unlock();
        }
    }

    public void reader(){
        lock.lock();
        try {
            int i = a;
        } finally {
            lock.unlock();
        }
    }
}