package org.ywb.study.ch3.netty.demo2;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

/**
 * date: 2017/4/24 13:52
 * description: 利用 LineBasedFrameDecoder 和 StringDecoder 解决 tcp 拆包和粘包的问题
 */
public class TimeServer {

    public void run(int port) throws Exception{
        // NioEventLoopGroup nio线程组，包含一组nio线程，专门用于网络事件的处理，一个用于接收连接，另一个用于ServerChannel的读写
        EventLoopGroup boss = new NioEventLoopGroup();
        EventLoopGroup worker = new NioEventLoopGroup();

        try {
            // 配置服务端的NIO线程
            ServerBootstrap b = new ServerBootstrap();
            b.group(boss, worker)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 1024)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            // 支持tcp粘包
                            ch.pipeline().addLast(new LineBasedFrameDecoder(1024));// LineBasedFrameDecoder 判断消息中是否有\n, \r\n，并以此作为结束标志
                            ch.pipeline().addLast(new StringDecoder()); // 将收到的消息转成string
                            ch.pipeline().addLast(new TimeServerHandler());
                        }
                    });
            // 绑定端口，同步等待成功
            ChannelFuture f = b.bind(port).sync();
            // 等待服务监听端口关闭
            f.channel().closeFuture().sync();
        } finally {
            // 优雅退出，释放资源
            boss.shutdownGracefully();
            worker.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception {
        new TimeServer().run(8080);
    }
}
