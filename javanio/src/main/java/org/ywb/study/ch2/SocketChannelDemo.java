package org.ywb.study.ch2;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * User: yangwenbiao@passiontec.cn
 * Date: 2017/3/27
 * Time: 11:43
 */
public class SocketChannelDemo {
    public static void main(String[] args) throws IOException {
        SocketChannel channel = SocketChannel.open();
        channel.connect(new InetSocketAddress("http://www.baidu.com", 80));

        ByteBuffer buffer = ByteBuffer.allocate(48);
        int read = channel.read(buffer);


    }
}
