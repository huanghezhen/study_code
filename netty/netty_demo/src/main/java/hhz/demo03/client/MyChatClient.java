package hhz.demo03.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ClassName: MyClient
 * @Description: TODO(概况)
 * @author: huanghz
 * @date: 2019/8/31 下午 03:11
 */
public class MyChatClient
{
    public static void main(String[] args) throws InterruptedException, IOException
    {
        EventLoopGroup eventExecutors = new NioEventLoopGroup();
        try
        {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(eventExecutors).channel(NioSocketChannel.class)
                    .handler(new MyChatClientInitializer());

            Channel channel = bootstrap.connect("localhost", 8899).sync().channel();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            while (true)
            {
                channel.writeAndFlush(br.readLine() + "\r\n");
            }
        }finally
        {
            eventExecutors.shutdownGracefully();
        }
    }
}
