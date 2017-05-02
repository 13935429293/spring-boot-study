package org.ywb.study.demo.discard;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCountUtil;

import java.nio.ByteBuffer;

/**
 * User: yangwenbiao@passiontec.cn
 * Date: 2017/3/31
 * Time: 18:28
 * <p>
 * 服务处理通道
 * 要实现DISCARD协议，唯一需要做的是忽略所有接收到的数据。让我们从处理器实现开始，它处理由Netty生成的I / O事件。
 * <p>
 * ChannelInboundHandlerAdapter 实现了 ChannelInboundHandler 接口。这个接口提供了可以覆盖的各种事件处理程序方法。
 */
public class DiscardServerHandler extends ChannelInboundHandlerAdapter {

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
        // super.channelRead(ctx, msg);
        /*
        ByteBuf是一个引用计数对象，必须通过release（）方法显式释放。
        通常调用channelRead 的方法时候，必须释放，常用的处理方式如下
        public void channelRead(ChannelHandlerContext ctx, Object msg) {
            try {
                // Do something with msg
            } finally {
                ReferenceCountUtil.release(msg);
            }
        }
         */
        // ((ByteBuf) msg).release();

        ByteBuf in = (ByteBuf) msg;
        // try {
        //     while (in.isReadable()) {
        //         System.out.println((char) in.readByte());
        //         System.out.flush();
        //     }
        // } finally {
        //     ReferenceCountUtil.release(msg);
        // }

        // try {
        //     System.out.println(in.toString(CharsetUtil.US_ASCII));
        // } finally {
        //     in.release();
        // }

        ctx.write(msg);
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
