package org.ywb.study.demo.discard;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * User: yangwenbiao
 * Date: 2017/3/31
 * Time: 18:43
 * <p>
 * 丢弃服务，启动服务
 */
public class Server {

    private int port;

    public Server(int port) {
        this.port = port;
    }

    public void run() throws Exception {
        /*
         NioEventLoopGroup是一个处理I / O操作的多线程事件循环。 Netty为不同类型的传输提供了各种EventLoopGroup实现。
         第一个，通常称为“老板”，接受传入的连接。
         第二个，通常称为“工人”，一旦老板接受连接并将接受的连接注册给工作人员，就处理接受的连接的流量。
         使用多少线程以及它们如何映射到创建的通道取决于EventLoopGroup实现，甚至可以通过构造函数进行配置。
          */
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            // 用于设置服务器
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class) // 使用NioServerSocketChannel实例化Channel接收传入的链接
                    /*
                    通过添加一些处理程序（如DiscardServerHandler）来配置新通道的ChannelPipeline来实现您的网络应用程序
                     */
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            // 在channel的管道中添加到顶部的
                            // ch.pipeline().addLast(new DiscardServerHandler());
                            ch.pipeline().addLast(new TimeServerHandler());
                        }
                    })
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.SO_KEEPALIVE, true);

            ChannelFuture f = b.bind(port).sync();

            f.channel().closeFuture().sync();
        } finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception {
        int port = 8888;
        new Server(port).run();
    }
}
