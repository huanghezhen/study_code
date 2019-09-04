package hhz.demo07.client;

import hhz.demo07.MyDataInfo;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Random;

/**
 * @ClassName: TestClientHandler
 * @Description: TODO(概况)
 * @author: huanghz
 * @date: 2019/9/1 下午 03:42
 */
public class TestClientHandler extends SimpleChannelInboundHandler<MyDataInfo.MyMessage>
{
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyDataInfo.MyMessage msg) throws Exception
    {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception
    {
        int randomInt = new Random().nextInt(3);
        MyDataInfo.MyMessage myMessage = null;
        if (0 == randomInt)
        {
            myMessage = MyDataInfo.MyMessage.newBuilder().setDataType(MyDataInfo.MyMessage.DataType.PersonType)
                    .setPerson(MyDataInfo.Person.newBuilder()
                            .setName("张三")
                            .setAge(20)
                            .setAddress("南京").build()).build();
        }
        else if (1 == randomInt)
        {
            myMessage = MyDataInfo.MyMessage.newBuilder().setDataType(MyDataInfo.MyMessage.DataType.DogType)
                    .setDog(MyDataInfo.Dog.newBuilder()
                            .setName("小狗")
                            .setAge(2).build()).build();
        }
        else if (2 == randomInt)
        {
            myMessage = MyDataInfo.MyMessage.newBuilder().setDataType(MyDataInfo.MyMessage.DataType.CatType)
                    .setCat(MyDataInfo.Cat.newBuilder()
                            .setName("小猫")
                            .setAddress("南京").build()).build();
        }

        ctx.channel().writeAndFlush(myMessage);
    }
}
