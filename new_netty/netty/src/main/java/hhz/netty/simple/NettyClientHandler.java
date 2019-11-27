package hhz.netty.simple;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/**
 * @ClassName: NettyClientHandler
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/11/27 14:59
 */
public class NettyClientHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.format("client = %s \n", ctx.toString());
        ctx.writeAndFlush(Unpooled.copiedBuffer("hello,server", CharsetUtil.UTF_8));
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf) msg;
        System.out.format("服务器的消息:%s \n", byteBuf.toString(CharsetUtil.UTF_8));
        System.out.format("服务器的地址:%s \n", ctx.channel().remoteAddress().toString());;
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
