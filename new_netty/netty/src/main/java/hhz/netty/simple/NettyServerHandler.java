package hhz.netty.simple;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/**
 * @ClassName: NettyServerHandler
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/11/27 14:06
 */
public class NettyServerHandler extends ChannelInboundHandlerAdapter {
    /**
     * @Description: 读取数据
     * @Param: [ctx, msg]
     * @Return: void
     * @Author: huanghz
     * @Date: 2019/11/27 14:08
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.format("server ctx = %s \n",ctx);
        // 将msg转为一个byteBuf
        ByteBuf byteBuf = (ByteBuf) msg;
        System.out.format("客户端发送的消息是:%s \n",byteBuf.toString(CharsetUtil.UTF_8));
        System.out.format("客户端地址:%s \n", ctx.channel().remoteAddress().toString());
    }

    /**
     * @Description: 读取完毕
     * @Param: [ctx]
     * @Return: void
     * @Author: huanghz
     * @Date: 2019/11/27 14:20
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        //  将数据写入缓冲并刷新
        // 一般讲 我们对这个发送的数据进行编码
        ctx.writeAndFlush(Unpooled.copiedBuffer("hello,客户端",CharsetUtil.UTF_8));
    }

    /**
     * @Description: 处理异常,关闭通道
     * @Param: [ctx, cause]
     * @Return: void
     * @Author: huanghz
     * @Date: 2019/11/27 14:23
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
