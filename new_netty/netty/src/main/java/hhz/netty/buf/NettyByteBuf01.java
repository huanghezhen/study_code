package hhz.netty.buf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

/**
 * @ClassName: NettyByteBuf01
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/11/28 11:02
 */
public class NettyByteBuf01 {
    public static void main(String[] args) throws Exception {
        ByteBuf buffer = Unpooled.buffer(10);


        for (int i = 0; i < 5; i++) {
             buffer.writeByte(i);
        }

        for (int i = 0; i < buffer.writerIndex(); i++) {
            System.out.println(buffer.getByte(i));
        }

        System.out.println();

        for (int i = 0; i < buffer.writerIndex(); i++) {
            System.out.println(buffer.readByte());
        }
    }
}
