package org.ywb.study.demo.pojo;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;

/**
 * User: yangwenbiao@passiontec.cn
 * Date: 2017/4/5
 * Time: 13:36
 */
public class TimeEncoder extends ChannelOutboundHandlerAdapter {
    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        UnixTime m = (UnixTime) msg;
        ByteBuf encoder = ctx.alloc().buffer(4);
        encoder.writeInt((int) m.value());
        ctx.write(encoder, promise);
    }
}
