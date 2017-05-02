package org.ywb.study.netty.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import org.msgpack.MessagePack;

import java.util.List;

/**
 * date: 2017/4/24 17:14
 * description:
 */
public class MsgPackDecoder extends MessageToMessageDecoder<ByteBuf> {

    /**
     * 现从ByteBuf 中获取要解码的byte数组，然后调用MessagePack的read方法将其反序列化为Object对象，将解码后的对象加入到解码列表中
     * @param ctx
     * @param msg
     * @param out
     * @throws Exception
     */
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {
        int length = msg.readableBytes();
        byte[] bytes = new byte[length];
        msg.getBytes(msg.readerIndex(), bytes, 0, length);
        MessagePack msgPack = new MessagePack();
        out.add(msgPack.read(bytes));
    }
}
