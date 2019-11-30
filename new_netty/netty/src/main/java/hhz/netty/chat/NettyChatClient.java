package hhz.netty.chat;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @ClassName: NettyChatClient
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/11/29 11:20
 */
public class NettyChatClient {
    private NettyChatClient() {
        EventLoopGroup workGroup = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();

        try {
            bootstrap.group(workGroup)
                    .channel(NioSocketChannel.class)
                    .handler(new NettyChatClientInitializer())
                    .connect("127.0.0.1", 8888)
                    .sync()
                    .channel()
                    .closeFuture()
                    .sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            workGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception {
        new NettyChatClient();
    }
}
