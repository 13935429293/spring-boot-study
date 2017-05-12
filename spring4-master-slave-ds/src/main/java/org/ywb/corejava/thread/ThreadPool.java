package org.ywb.corejava.thread;

/**
 * User: yangwenbiao
 * Date: 2017/3/10
 * Time: 16:39
 */
public interface ThreadPool<Job extends Runnable> {
    void execute(Job job);

    void shutdown();

    void addWorker(int num);

    void removeWorker(int num) throws IllegalAccessException;

    int getJobSize();
}
