package hhz.netty.http.server;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

import java.net.URI;

/**
 * @ClassName: HttpServerHandler
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/11/27 16:41
 */
public class HttpServerHandler extends SimpleChannelInboundHandler<HttpObject> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HttpObject msg) throws Exception {
        // 判断 msg
        if (msg instanceof HttpRequest) {
            System.out.println("msg class : " + msg.getClass());
            System.out.println("客户端地址" + ctx.channel().remoteAddress());


            HttpRequest httpRequest = (HttpRequest) msg;

            URI uri = new URI(httpRequest.uri());
            if ("/favicon.ico".equals(uri.getPath())) {
                System.out.println("favicon.ico 不处理");
                return;
            }



            ByteBuf content = Unpooled.copiedBuffer("hello , 我是服务器", CharsetUtil.UTF_8);

            FullHttpResponse defaultFullHttpResponse = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, content);

            defaultFullHttpResponse.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plain");
            defaultFullHttpResponse.headers().set(HttpHeaderNames.CONTENT_LENGTH, content.readableBytes());
            ctx.writeAndFlush(defaultFullHttpResponse);
        }
    }
}
