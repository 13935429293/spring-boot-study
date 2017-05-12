package org.ywb.study.ch1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * User: yangwenbiao
 * Date: 2017/3/13
 * Time: 17:49
 * <p>
 * 1. 创建一个DatagramSocket实例，指定本地端口号，并可以选择指定本地地址。此时，服务器已经准备好从任何客户端接收数据报文。
 * <p>
 * 2. 使用DatagramSocket类的receive()方法来接收一个DatagramPacket实例。当receive()方法返回时，数据报文就包含了客户端的地址，
 * 这样我们就知道了回复信息应该发送到什么地方。
 * <p>
 * 3. 使用DatagramSocket类的send() 和receive()方法来发送和接收DatagramPackets实例，进行通信。
 */
public class UdpEchoServer {

    private static final int ECHOMAX = 255;
    private static Integer port = 8080;

    public static void main(String[] args) throws IOException{

        DatagramSocket socket = new DatagramSocket(port);
        DatagramPacket packet = new DatagramPacket(new byte[ECHOMAX], ECHOMAX); // 数据报文

        while (true) {
            // UDP服务器为所有的通信使用同一个套接字，这点与TCP服务器不同，TCP服务器为每个成功返回的accept()方法创建一个新的套接字。
            socket.receive(packet);
            System.out.println("Handling client at " + packet.getAddress().getHostAddress()  + " on port " + packet.getPort());

            socket.send(packet);

            packet.setLength(ECHOMAX);
        }


    }
}
