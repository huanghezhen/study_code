package hhz.dubbo.netty;

import hhz.dubbo.provider.HelloServerImpl;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * huanghz
 * 2019/12/1 下午3:37
 */
public class NettyServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        // 获取客户端发送的消息.

        String msgStr = msg.toString();
        System.out.println("msg=" + msgStr);

        // 比如每次发送消息的时候.都必须以某个字符串开头

        if (msgStr.startsWith("HelloServer#hello#")) {
            String ret = new HelloServerImpl().hello(msgStr.substring(msgStr.lastIndexOf("#") + 1));
            ctx.writeAndFlush(ret);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
