package org.ywb.study.ch3.netty.demo1;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.concurrent.EventExecutorGroup;

/**
 * date: 2017/4/24 14:39
 * description:
 */
public class TimeClientHandler extends ChannelInboundHandlerAdapter {

    private final ByteBuf msg;

    public TimeClientHandler() {
        byte[] bytes = "QUERY TIME ORDER".getBytes();
        msg = Unpooled.buffer(bytes.length);
        msg.writeBytes(bytes);
    }

    /**
     * tcp 链路建立成功后，netty会调用此方法，
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(msg);
    }

    /**
     * 服务器返回应答消息时，调用此方法
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = (ByteBuf) msg;
        byte[] bytes = new byte[buf.readableBytes()];
        buf.readBytes(bytes);
        String body = new String(bytes, "UTF-8");
        System.out.println("Now is : " + body);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
