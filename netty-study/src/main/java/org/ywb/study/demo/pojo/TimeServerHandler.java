package org.ywb.study.demo.pojo;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * User: yangwenbiao
 * Date: 2017/4/5
 * Time: 10:14
 */
public class TimeServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        ChannelFuture f = ctx.writeAndFlush(new UnixTime());
        f.addListener(ChannelFutureListener.CLOSE);
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
