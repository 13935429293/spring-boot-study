package org.ywb.study.ch3.netty.demo2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * date: 2017/4/24 14:39
 * description:
 */
public class TimeClientHandler extends ChannelInboundHandlerAdapter {

    // private final ByteBuf msg;
    private int counter;
    private byte[] bytes;

    public TimeClientHandler() {
        bytes = ("QUERY TIME ORDER" + System.getProperty("line.separator")).getBytes();
    }

    /**
     * tcp 链路建立成功后，netty会调用此方法，
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ByteBuf msg = null;
        for (int i = 0; i < 100; i++) {
            msg = Unpooled.buffer(bytes.length);
            msg.writeBytes(bytes);
            ctx.writeAndFlush(msg);
        }
    }

    /**
     * 服务器返回应答消息时，调用此方法
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        String body = (String) msg;
        System.out.println("Now is : " + body + ", the counter is : " + ++counter);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
