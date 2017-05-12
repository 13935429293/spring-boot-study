package org.ywb.study.netty.ch1;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EchoServerHandler extends ChannelInboundHandlerAdapter {

    private static final Logger logger = LoggerFactory.getLogger(
            EchoServerHandler.class.getName());  

    @Override  
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ctx.write(msg);  
    }  

    @Override  
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {  
        ctx.flush();  
    }  

    @Override  
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {  
        // Close the connection when an exception is raised.  
        logger.warn("Unexpected exception from downstream.", cause);
        ctx.close();  
    }  
}