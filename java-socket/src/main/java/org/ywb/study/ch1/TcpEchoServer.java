package org.ywb.study.ch1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * User: yangwenbiao
 * Date: 2017/3/13
 * Time: 16:23
 * <p>
 * 1. 创建一个ServerSocket实例并指定本地端口。此套接字的功能是侦听该指定端口收到的连接。
 * <p>
 * 2. 重复执行：
 * <p>
 * a. 调用ServerSocket的accept()方法以获取下一个客户端连接。基于新建立的客户端连接，创建一个Socket实例，并由accept()方法返回。
 * <p>
 * b. 使用所返回的Socket实例的InputStream和OutputStream与客户端进行通信。
 * <p>
 * c. 通信完成后，使用Socket类的close()方法关闭该客户端套接字连接。
 */
public class TcpEchoServer {

    private static final int BUFSIZE = 32;

    private static Integer port = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(port);

        System.out.println(server.getLocalPort());
        System.out.println(server.getLocalSocketAddress());

        int recvMsgSize; // Size of received message
        byte[] receiveBuf = new byte[BUFSIZE];

        while (true) {
            // accept()方法为下一个传入的连接请求创建Socket实例，并将已成功连接的Socket实例返回给服务器端套接字。
            // 如果没有连接请求等待，accept()方法将阻塞等待，直到有新的连接请求到来或超时。
            Socket client = server.accept();

            SocketAddress clientAddress = client.getRemoteSocketAddress();
            System.out.println("Handing client at : " + clientAddress);

            InputStream in = client.getInputStream();
            OutputStream out = client.getOutputStream();

            while ((recvMsgSize = in.read(receiveBuf)) != -1) {
                out.write(receiveBuf, 0, recvMsgSize);
                System.out.println(new String(receiveBuf));
            }

            client.close();
        }


    }
}
