package org.ywb.corejava.thread;

/**
 * User: yangwenbiao@passiontec.cn
 * Date: 2017/3/8
 * Time: 18:31
 *
 * jps
 * jstack pid
 *
 * 线程在堆内存中等待运行
 */
public class ThreadState {
    /**
     * "BlockedThread02" #14 prio=5 os_prio=0 tid=0x000000001917b000 nid=0x3888 waiting for monitor entry [0x0000000019e9e000]
     * java.lang.Thread.State: BLOCKED (on object monitor)
     * at org.ywb.corejava.thread.ThreadState$Blocked.run(ThreadState.java:49)
     * - waiting to lock <0x00000000d5fc3dd0> (a java.lang.Class for org.ywb.corejava.thread.ThreadState$Blocked)
     * at java.lang.Thread.run(Thread.java:745)
     * <p>
     * "BlockedThread01" #13 prio=5 os_prio=0 tid=0x000000001917a000 nid=0x2cc4 waiting on condition [0x0000000019d9e000]
     * java.lang.Thread.State: TIMED_WAITING (sleeping)
     * at java.lang.Thread.sleep(Native Method)
     * at java.lang.Thread.sleep(Thread.java:340)
     * at java.util.concurrent.TimeUnit.sleep(TimeUnit.java:386)
     * at org.ywb.corejava.thread.SleepUtils.second(SleepUtils.java:13)
     * at org.ywb.corejava.thread.ThreadState$Blocked.run(ThreadState.java:49)
     * - locked <0x00000000d5fc3dd0> (a java.lang.Class for org.ywb.corejava.thread.ThreadState$Blocked)
     * at java.lang.Thread.run(Thread.java:745)
     * <p>
     * "WaitingThread" #12 prio=5 os_prio=0 tid=0x0000000019175000 nid=0x5074 in Object.wait() [0x0000000019c9e000]
     * java.lang.Thread.State: WAITING (on object monitor)
     * at java.lang.Object.wait(Native Method)
     * - waiting on <0x00000000d5fc1168> (a java.lang.Class for org.ywb.corejava.thread.ThreadState$Waiting)
     * at java.lang.Object.wait(Object.java:502)
     * at org.ywb.corejava.thread.ThreadState$Waiting.run(ThreadState.java:34)
     * - locked <0x00000000d5fc1168> (a java.lang.Class for org.ywb.corejava.thread.ThreadState$Waiting)
     * at java.lang.Thread.run(Thread.java:745)
     * <p>
     * "TimeWaitingThread" #11 prio=5 os_prio=0 tid=0x0000000019174000 nid=0x5264 waiting on condition [0x0000000019b9f000]
     * java.lang.Thread.State: TIMED_WAITING (sleeping)
     * at java.lang.Thread.sleep(Native Method)
     * at java.lang.Thread.sleep(Thread.java:340)
     * at java.util.concurrent.TimeUnit.sleep(TimeUnit.java:386)
     * at org.ywb.corejava.thread.SleepUtils.second(SleepUtils.java:13)
     * at org.ywb.corejava.thread.ThreadState$TimeWaiting.run(ThreadState.java:22)
     * at java.lang.Thread.run(Thread.java:745)
     * <p>
     * "Monitor Ctrl-Break" #10 daemon prio=5 os_prio=0 tid=0x0000000019170800 nid=0x5130 runnable [0x0000000019a0e000]
     * java.lang.Thread.State: RUNNABLE
     * at java.net.DualStackPlainSocketImpl.accept0(Native Method)
     * at java.net.DualStackPlainSocketImpl.socketAccept(DualStackPlainSocketImpl.java:131)
     * at java.net.AbstractPlainSocketImpl.accept(AbstractPlainSocketImpl.java:409)
     * at java.net.PlainSocketImpl.accept(PlainSocketImpl.java:199)
     * - locked <0x00000000d601bf08> (a java.net.SocksSocketImpl)
     * at java.net.ServerSocket.implAccept(ServerSocket.java:545)
     * at java.net.ServerSocket.accept(ServerSocket.java:513)
     * at com.intellij.rt.execution.application.AppMain$1.run(AppMain.java:79)
     * at java.lang.Thread.run(Thread.java:745)
     * <p>
     * "Service Thread" #9 daemon prio=9 os_prio=0 tid=0x0000000018eaa800 nid=0x24bc runnable [0x0000000000000000]
     * java.lang.Thread.State: RUNNABLE
     * <p>
     * "C1 CompilerThread2" #8 daemon prio=9 os_prio=2 tid=0x0000000018e26000 nid=0x44d4 waiting on condition [0x0000000000000000]
     * java.lang.Thread.State: RUNNABLE
     * <p>
     * "C2 CompilerThread1" #7 daemon prio=9 os_prio=2 tid=0x0000000018e19000 nid=0x52f8 waiting on condition [0x0000000000000000]
     * java.lang.Thread.State: RUNNABLE
     * <p>
     * "C2 CompilerThread0" #6 daemon prio=9 os_prio=2 tid=0x0000000017b1d000 nid=0x52f0 waiting on condition [0x0000000000000000]
     * java.lang.Thread.State: RUNNABLE
     * <p>
     * "Attach Listener" #5 daemon prio=5 os_prio=2 tid=0x0000000017b1b800 nid=0x511c waiting on condition [0x0000000000000000]
     * java.lang.Thread.State: RUNNABLE
     * <p>
     * "Signal Dispatcher" #4 daemon prio=9 os_prio=2 tid=0x0000000017acf000 nid=0x4c68 runnable [0x0000000000000000]
     * java.lang.Thread.State: RUNNABLE
     * <p>
     * "Finalizer" #3 daemon prio=8 os_prio=1 tid=0x0000000017aaa800 nid=0x3714 in Object.wait() [0x0000000018e0f000]
     * java.lang.Thread.State: WAITING (on object monitor)
     * at java.lang.Object.wait(Native Method)
     * - waiting on <0x00000000d5d88ee0> (a java.lang.ref.ReferenceQueue$Lock)
     * at java.lang.ref.ReferenceQueue.remove(ReferenceQueue.java:143)
     * - locked <0x00000000d5d88ee0> (a java.lang.ref.ReferenceQueue$Lock)
     * at java.lang.ref.ReferenceQueue.remove(ReferenceQueue.java:164)
     * at java.lang.ref.Finalizer$FinalizerThread.run(Finalizer.java:209)
     * <p>
     * "Reference Handler" #2 daemon prio=10 os_prio=2 tid=0x0000000017a89000 nid=0x654 in Object.wait() [0x0000000018d0f000]
     * java.lang.Thread.State: WAITING (on object monitor)
     * at java.lang.Object.wait(Native Method)
     * - waiting on <0x00000000d5d86b50> (a java.lang.ref.Reference$Lock)
     * at java.lang.Object.wait(Object.java:502)
     * at java.lang.ref.Reference.tryHandlePending(Reference.java:191)
     * - locked <0x00000000d5d86b50> (a java.lang.ref.Reference$Lock)
     * at java.lang.ref.Reference$ReferenceHandler.run(Reference.java:153)
     * <p>
     * "VM Thread" os_prio=2 tid=0x0000000017a87800 nid=0x13dc runnable
     * <p>
     * "GC task thread#0 (ParallelGC)" os_prio=0 tid=0x0000000002e88800 nid=0x5218 runnable
     * <p>
     * "GC task thread#1 (ParallelGC)" os_prio=0 tid=0x0000000002e8a000 nid=0x2148 runnable
     * <p>
     * "GC task thread#2 (ParallelGC)" os_prio=0 tid=0x0000000002e8b800 nid=0x4ecc runnable
     * <p>
     * "GC task thread#3 (ParallelGC)" os_prio=0 tid=0x0000000002e8d000 nid=0x5104 runnable
     * <p>
     * "VM Periodic Task Thread" os_prio=2 tid=0x0000000018ed1000 nid=0x4a60 waiting on condition
     * <p>
     * JNI global references: 15
     */
    public static void main(String[] args) {
        new Thread(new TimeWaiting(), "TimeWaitingThread").start();
        new Thread(new Waiting(), "WaitingThread").start();

        new Thread(new Blocked(), "BlockedThread01").start();
        new Thread(new Blocked(), "BlockedThread02").start();
    }

    static class TimeWaiting implements Runnable {

        @Override
        public void run() {
            while (true) {
                SleepUtils.second(100);
            }
        }
    }

    static class Waiting implements Runnable {

        @Override
        public void run() {
            while (true) {
                synchronized (Waiting.class) {
                    try {
                        Waiting.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    static class Blocked implements Runnable {

        @Override
        public void run() {
            while (true) {
                synchronized (Blocked.class) {
                    SleepUtils.second(100);
                }
            }
        }
    }

}
