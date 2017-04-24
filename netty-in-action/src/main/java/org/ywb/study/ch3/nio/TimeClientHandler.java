package org.ywb.study.ch3.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * date: 2017/4/19 19:20
 * description:
 */
public class TimeClientHandler implements Runnable {

    private String host;
    private int port;
    private Selector selector;
    private SocketChannel socketChannel;
    private volatile boolean stop;
    public TimeClientHandler(String host, int port) {
        this.host = host;
        this.port = port;
        try {
            selector = Selector.open();
            socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    @Override
    public void run() {
        try {
            doConnect();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        while (!stop) {
            try {
                selector.select(1000);
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> it = selectionKeys.iterator();
                SelectionKey key = null;
                while (it.hasNext()) {
                    key = it.next();
                    it.remove();

                    try {
                        handlerInput(key);
                    } catch (Exception e) {
                        e.printStackTrace();
                        if (key != null) {
                            key.cancel();
                            if (key.channel() != null) {
                                key.channel().close();
                            }
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        if (selector != null) {
            try {
                selector.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void handlerInput(SelectionKey key) throws Exception{
        if (key.isValid()) {
            SocketChannel sc = (SocketChannel) key.channel();
            if (key.isConnectable()) { // 已经相应ack
                if (sc.finishConnect()) {
                    sc.register(selector, SelectionKey.OP_READ);
                    doWrite(sc);
                } else {
                    System.exit(1);
                }
            }
            if (key.isReadable()) {
                ByteBuffer buffer = ByteBuffer.allocate(1024);
                int read = sc.read(buffer);
                if (read > 0) {
                    buffer.flip();
                    byte[] bytes = new byte[buffer.remaining()];
                    buffer.get(bytes);
                    String body = new String(bytes, "UTF-8");
                    System.out.println("Now is :" + body);
                    this.stop = true;
                } else if (read < 0) {
                    key.cancel();
                    sc.close();
                } else ;
            }
        }
    }

    private void doConnect() throws IOException {
        // 如果链接成功，注册 OP_READ 事件，如果没有成功，则说明服务端没有返回TCP的握手信息，但不表示失败，需要注册 CONNECT 事件，当服务端返回 TCP syn-ack 请求后，
        // selector就能够轮训到这个 SocketChannel 处于连接就绪状态
        if (socketChannel.connect(new InetSocketAddress(host, port))) {
            socketChannel.register(selector, SelectionKey.OP_READ);
            doWrite(socketChannel);
        } else {
            socketChannel.register(selector, SelectionKey.OP_CONNECT);
        }
    }

    private void doWrite(SocketChannel sc) throws IOException {
        byte[] req = "QUERY TIME ORDER".getBytes();
        ByteBuffer bu = ByteBuffer.allocate(req.length);
        bu.put(req);
        bu.flip();
        sc.write(bu);
        if (!bu.hasRemaining()) {
            System.out.println("send order 2 server suc.");
        }
    }
}
