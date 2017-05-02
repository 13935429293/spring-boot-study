package org.ywb.study.ch2;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * date: 2017/4/19 14:53
 * description:
 */
public class NioServerDemo {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.socket().bind(new InetSocketAddress(InetAddress.getByName("IP"), 8888));
        ssc.configureBlocking(false);// 设置链接为非阻塞链接

        Selector selector = Selector.open();
        ssc.register(selector, SelectionKey.OP_ACCEPT);

        int num = selector.select();
        Set<SelectionKey> selectionKeys = selector.selectedKeys();
        Iterator<SelectionKey> it = selectionKeys.iterator();
        while (it.hasNext()) {
            SelectionKey next = it.next();
            SocketChannel accept = ssc.accept();
            accept.configureBlocking(false);
            accept.socket().setReuseAddress(true);
            accept.register(selector, SelectionKey.OP_READ);
        }
    }
}
