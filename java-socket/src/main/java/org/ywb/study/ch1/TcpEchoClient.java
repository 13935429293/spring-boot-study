package org.ywb.study.ch1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;

/**
 * User: yangwenbiao
 * Date: 2017/3/13
 * Time: 15:22
 * <p>
 * Java为TCP协议提供了两个类：Socket类和ServerSocket类。一个Socket实例代表了TCP连接的一端。
 * 一个TCP连接（TCP connection）是一条抽象的双向信道，两端分别由IP地址和端口号确定。
 * 在开始通信之前，要建立一个TCP连接，这需要先由客户端TCP向服务器端TCP发送连接请求。
 * ServerSocket实例则监听TCP连接请求，并为每个请求创建新的Socket实例。
 * 也就是说，服务器端要同时处理ServerSocket实例和Socket实例，而客户端只需要使用Socket实例。
 * <p>
 * 客户端向服务器发起连接请求后，就被动地等待服务器的响应。典型的TCP客户端要经过下面三步：
 * 1. 创建一个Socket实例：构造器向指定的远程主机和端口建立一个TCP连接。
 * 2. 通过套接字的输入输出流（I/O streams）进行通信：一个Socket连接实例包括一个InputStream和一个OutputStream，它们的用法同于其他Java输入输出流。
 * 3. 使用Socket类的close()方法关闭连接。
 */
public class TcpEchoClient {

    private static String server = "127.0.0.1";
    private static Integer port = 8080;
    private static byte[] data = "this is a socket client.".getBytes();

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(server, port);

        InputStream in = socket.getInputStream();// 用于接收数据
        OutputStream out = socket.getOutputStream();// 用于发送数据

        out.write(data); // Send the encoded string to the server

        int totalByteRcvd = 0;
        int bytesRcvd;

        while (totalByteRcvd < data.length) {
            if ((bytesRcvd = in.read(data, totalByteRcvd, data.length - totalByteRcvd)) == -1) {
                throw new SocketException("Connection closed prematurely");
            }
            totalByteRcvd += bytesRcvd;
        }

        System.out.println(new String(data));

        socket.close();
    }
}
