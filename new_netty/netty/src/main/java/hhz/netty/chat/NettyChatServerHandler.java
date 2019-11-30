package hhz.netty.chat;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName: NettyChatServerHandler
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/11/29 11:17
 */
public class NettyChatServerHandler extends SimpleChannelInboundHandler<String> {

    private static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        String msg = ctx.channel().remoteAddress().toString()+" "+ sdf.format(new Date()) + ": 上线";
        channelGroup.writeAndFlush(msg);
        channelGroup.add(ctx.channel());
        System.out.println(msg);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        String msg = ctx.channel().remoteAddress().toString() + " " + sdf.format(new Date()) + ": 下线";
        channelGroup.remove(ctx.channel());
        channelGroup.writeAndFlush(msg);
        System.out.println(msg);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {

    }

}
