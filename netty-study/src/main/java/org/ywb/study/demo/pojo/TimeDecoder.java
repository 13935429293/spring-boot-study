package org.ywb.study.demo.pojo;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * User: yangwenbiao
 * Date: 2017/4/5
 * Time: 10:29
 */
public class TimeDecoder extends ByteToMessageDecoder {

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        if (in.readableBytes() < 4)
            return;

        out.add(new UnixTime(in.readUnsignedInt()));
    }
}
