package org.ywb.study.ch3.nio;

/**
 * date: 2017/4/19 17:51
 * description:
 */
public class TimeServer {

    public static void main(String[] args) throws InterruptedException {
        MultiplexerTimeServer timeServer = new MultiplexerTimeServer(8888);
        new Thread(timeServer, "NIO-MultiplexerTimeServer-001").start();

        // Thread.sleep(Long.MAX_VALUE);
    }
}
