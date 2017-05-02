package org.ywb.study.netty.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.msgpack.MessagePack;

/**
 * date: 2017/4/24 17:05
 * description: messagePack 编码器，继承 MessageToByteEncode<Object>
 */
public class MsgPackEncoder extends MessageToByteEncoder<Object> {

    @Override
    protected void encode(ChannelHandlerContext ctx, Object msg, ByteBuf out) throws Exception {
        MessagePack msgPack = new MessagePack();
        byte[] write = msgPack.write(msg); // 将obj类型的pojo编码为二进制对象，写到buf中
        out.writeBytes(write);
    }
}
