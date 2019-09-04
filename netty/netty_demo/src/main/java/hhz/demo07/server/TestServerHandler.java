package hhz.demo07.server;

import hhz.demo07.MyDataInfo;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @ClassName: TestServerHandler
 * @Description: TODO(概况)
 * @author: huanghz
 * @date: 2019/9/1 下午 03:37
 */
public class TestServerHandler extends SimpleChannelInboundHandler<MyDataInfo.MyMessage>
{
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyDataInfo.MyMessage msg) throws Exception
    {
        switch (msg.getDataType())
        {
            case PersonType:
                System.out.println(msg.getPerson().getName());
                System.out.println(msg.getPerson().getAge());
                System.out.println(msg.getPerson().getAddress());
                break;
            case CatType:
                System.out.println(msg.getCat().getName());
                System.out.println(msg.getCat().getAddress());
                break;
            case DogType:
                System.out.println(msg.getDog().getName());
                System.out.println(msg.getDog().getAge());
                break;
        }
    }
}
