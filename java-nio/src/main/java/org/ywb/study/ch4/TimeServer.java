package org.ywb.study.ch4;

import java.io.IOException;

/**
 * User: yangwenbiao
 * Date: 2017/3/27
 * Time: 18:38
 */
public class TimeServer {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        int port = 8080;
        MultiplexerTimeServer timeServer = new MultiplexerTimeServer(port);
        new Thread(timeServer, "NIO-MultiplexerTimeServer-001").start();
    }
}

