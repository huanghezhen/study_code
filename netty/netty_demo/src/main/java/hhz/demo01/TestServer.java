package hhz.demo01;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.sctp.nio.NioSctpServerChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @ClassName: TestServer
 * @Description: TODO(概况)
 * @author: huanghz
 * @date: 2019/8/30 下午 04:34
 */
public class TestServer
{
    public static void main(String[] args) throws Exception
    {
        // 只接收链接
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        // 处理链接
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try
        {
            // 启动服务
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
                    .childHandler(new TestServiceInitializer());

            ChannelFuture channelFuture = serverBootstrap.bind(8899).sync();
            channelFuture.channel().closeFuture().sync();

        }
        finally
        {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
