package hhz.demo07.client;

import hhz.demo03.client.MyChatClientInitializer;
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
 * @ClassName: TestClient
 * @Description: TODO(概况)
 * @author: huanghz
 * @date: 2019/9/1 下午 03:41
 */
public class TestClient
{
    public static void main(String[] args) throws Exception
    {
        EventLoopGroup eventExecutors = new NioEventLoopGroup();
        try
        {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(eventExecutors).channel(NioSocketChannel.class)
                    .handler(new TestClientInitializer());

            ChannelFuture localhost = bootstrap.connect("localhost", 8899).sync();
            localhost.channel().closeFuture().sync();
        }finally
        {
            eventExecutors.shutdownGracefully();
        }
    }
}
