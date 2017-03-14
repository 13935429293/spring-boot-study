package org.ywb.corejava.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2017/3/14.
 */
public class ReentrantLockCondition implements Runnable {
    public static ReentrantLock lock = new ReentrantLock();
    public static Condition condition = lock.newCondition();
    @Override
    public void run() {
        try {
            // Thread.sleep(3000);
            lock.lock();
            condition.await();
            System.out.println("The Thread is done");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new ReentrantLockCondition(), "ReentrantLock");
        t.start();
        Thread.sleep(2000);
        lock.lock();
        System.out.println("Main Thread is done");
        condition.signal(); // 如果不sleep 线程还没有wait就已经通知了，导致一致等待，wait
        lock.unlock();
    }
}
