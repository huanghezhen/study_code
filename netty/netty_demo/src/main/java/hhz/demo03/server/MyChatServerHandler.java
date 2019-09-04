package hhz.demo03.server;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.util.UUID;

/**
 * @ClassName: MyServerHandler
 * @Description: TODO(概况)
 * @author: huanghz
 * @date: 2019/8/31 下午 03:04
 */
public class MyChatServerHandler extends SimpleChannelInboundHandler<String>
{

    private static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception
    {
        Channel channel = ctx.channel();
        channelGroup.forEach(channel1 -> {
            if (channel != channel1)
            {
                channel1.writeAndFlush(channel.remoteAddress() + " 发送的消息: " + msg + "\n");
            }else {
                channel1.writeAndFlush("[自己]: " + msg + "\n");
            }
        });
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception
    {
        Channel channel = ctx.channel();
        channelGroup.writeAndFlush("[服务器] - " + channel.remoteAddress() + "加入\n");
        channelGroup.add(channel);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception
    {
        Channel channel = ctx.channel();
        // 会自己调用
        //channelGroup.remove(channel);
        channelGroup.writeAndFlush("[服务器] - " + channel.remoteAddress() + "离开\n");
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception
    {
        Channel channel = ctx.channel();
        System.out.println(channel.remoteAddress()+" 上线\n");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception
    {
        Channel channel = ctx.channel();
        System.out.println(channel.remoteAddress()+" 下线\n");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception
    {
       // cause.printStackTrace();
        ctx.close();
    }
}
