package hhz.netty.http.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * @ClassName: HttpServerInitializer
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/11/27 16:42
 */
public class HttpServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();

        pipeline.addLast("MyHttpServerCodec", new HttpServerCodec());
        pipeline.addLast("MyHttpServerHandler", new HttpServerHandler());
    }
}
