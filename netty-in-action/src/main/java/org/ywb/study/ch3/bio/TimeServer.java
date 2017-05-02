package org.ywb.study.ch3.bio;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * date: 2017/4/19 16:45
 * description: 同步阻塞I/O 创建TimeServer
 */
public class TimeServer {

    public static void main(String[] args) throws Exception {
        ServerSocket server = null;

        try {
            server = new ServerSocket(8888);
            System.out.println("The time server start in port 8888");

            Socket socket = null;
            TimeServerHandlerExecutePool execute = new TimeServerHandlerExecutePool(50, 10000);
            while (true) {
                socket = server.accept();
                execute.execute(new TimeServerHandler(socket));
            }
        } finally {
            if (null != server) {
                System.out.println("server is close");
                server.close();
                server = null;
            }
        }
    }
}
