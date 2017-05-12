package org.ywb.study.demo.pojo;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.Date;

/**
 * User: yangwenbiao
 * Date: 2017/4/5
 * Time: 10:31
 */
public class TimeClientHandler extends ChannelInboundHandlerAdapter {

    /**
     * 每当从客户端收到新数据时，都会使用接收到的消息调用此方法。
     * 实现DISCARD协议，处理程序必须忽略收到的消息。
     *
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        UnixTime time = (UnixTime) msg;
        System.out.println(time);
        ctx.close();
    }


    /**
     * 由于I / O错误或由处理事件引发的异常引发的处理程序实现，Netty引发了异常。
     * 在大多数情况下，应该记录捕获到的异常，并且在此关闭的通道应该在这里关闭，尽管这种方法的实现可以根据您想要处理的异常情况而有所不同。
     *
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        // super.exceptionCaught(ctx, cause);
        cause.printStackTrace();
        ctx.close();
    }
}
