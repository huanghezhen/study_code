package hhz.demo02.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @ClassName: MyClient
 * @Description: TODO(概况)
 * @author: huanghz
 * @date: 2019/8/31 下午 03:11
 */
public class MyClient
{
    public static void main(String[] args) throws InterruptedException
    {
        EventLoopGroup eventExecutors = new NioEventLoopGroup();
        try
        {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(eventExecutors).channel(NioSocketChannel.class)
                    .handler(new MyClientInitializer());

            ChannelFuture channelFuture = bootstrap.connect("localhost", 8899).sync();
            channelFuture.channel().closeFuture().sync();
        }finally
        {
            eventExecutors.shutdownGracefully();
        }
    }
}
