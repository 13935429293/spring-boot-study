package org.ywb.study.ch1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * User: yangwenbiao@passiontec.cn
 * Date: 2017/3/13
 * Time: 18:08
 * <p>
 * <p>
 * UDP客户端首先向被动等待联系的服务器端发送一个数据报文。一个典型的UDP客户端主要执行以下三步：
 * <p>
 * 1. 创建一个DatagramSocket实例，可以选择对本地地址和端口号进行设置。
 * <p>
 * 2. 使用DatagramSocket类的send() 和 receive()方法来发送和接收DatagramPacket实例，进行通信。
 * <p>
 * 3. 通信完成后，使用DatagramSocket类的close()方法来销毁该套接字。
 */
public class UdpEchoClientTimeout {

    private static final int TIMEOUT = 3000;
    private static final int MAXTRIES = 5;

    private static String server = "127.0.0.1";
    private static Integer port = 8080;
    private static byte[] data = "this is a socket client.".getBytes();

    public static void main(String[] args) throws IOException {

        DatagramSocket socket = new DatagramSocket();
        socket.setSoTimeout(TIMEOUT);
        InetAddress serverAddress = InetAddress.getByName("127.0.0.1");

        DatagramPacket packet = new DatagramPacket(data, data.length, serverAddress, port);

        int tries = 0;
        boolean receivedResponse = false;
        do {
            socket.send(packet);

            try {
                socket.receive(packet);
                if (!packet.getAddress().equals(serverAddress)) {
                    throw new IOException("Received packet from an unknown source");
                }
                receivedResponse = true;
            } catch (IOException e) {
                tries += 1;
                System.out.println("Timed out, " + (MAXTRIES - tries) + " more tries...");
            }
        } while ((!receivedResponse) && (tries < MAXTRIES));

        if (receivedResponse) {
            System.out.println("Received: " + new String(packet.getData()));
        } else {
            System.out.println("No response -- giving up.");
        }
        socket.close();
    }
}
