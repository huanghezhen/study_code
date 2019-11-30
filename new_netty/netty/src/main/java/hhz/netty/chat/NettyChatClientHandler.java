package hhz.netty.chat;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @ClassName: NettyChatClientHandler
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/11/29 11:25
 */
public class NettyChatClientHandler  extends SimpleChannelInboundHandler<String> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println(msg);
    }
}
