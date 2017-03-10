package org.ywb.corejava.thread;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * User: yangwenbiao@passiontec.cn
 * Date: 2017/3/8
 * Time: 18:22
 * <p>
 * [10]Monitor Ctrl-Break
 * [5]Attach Listener
 * [4]Signal Dispatcher
 * [3]Finalizer
 * [2]Reference Handler
 * [1]main
 */
public class MultiThread {
    public static void main(String[] args) {
        // 获取java线程管理MxBean
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        // 不需要获取同步的 monitor 和 synchronizer 信息， 仅获取线程和线程堆栈信息
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        // 遍历线程信息，带打印线程Id 和 线程明名称信息
        for (ThreadInfo threadInfo : threadInfos) {
            System.out.println("[" + threadInfo.getThreadId() + "]" + threadInfo.getThreadName());
        }
    }
}
