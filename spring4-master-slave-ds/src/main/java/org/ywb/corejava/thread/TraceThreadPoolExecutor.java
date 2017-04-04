package org.ywb.corejava.thread;

import java.util.concurrent.*;

/**
 * Created by Administrator on 2017/3/27.
 */
public class TraceThreadPoolExecutor extends ThreadPoolExecutor {
    public static class DivTask implements Runnable{
        int a,b;

        public DivTask(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public void run() {
            double re = a/b;
            System.out.println(re);
        }
    }

    public TraceThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    @Override
    public void execute(Runnable command) {
        super.execute(wrap(command, clientTrace(), Thread.currentThread().getName()));
    }

    @Override
    public Future<?> submit(Runnable task) {
        return super.submit(wrap(task, clientTrace(), Thread.currentThread().getName()));
    }

    private Exception clientTrace() {
        return new Exception("Client stack trace");
    }

    private Runnable wrap(final Runnable task, final Exception clientStack, String clientThreadName) {
        return new Runnable() {
            @Override
            public void run() {
                try {
                    task.run();
                } catch (Exception e) {
                    clientStack.getStackTrace();
                    throw e;
                }
            }
        };
    }

    public static void main(String[] args) {
        ExecutorService es = new TraceThreadPoolExecutor(0, Integer.MAX_VALUE, 0L, TimeUnit.MICROSECONDS, new SynchronousQueue<Runnable>());

        for (int i = 0; i < 5; i++) {
            es.execute(new DivTask(100, i));
        }
    }
}
