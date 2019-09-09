package hhz.demo12.nio;

import java.nio.Buffer;
import java.nio.ByteBuffer;

/**
 * @ClassName: NioTest05
 * @Description: TODO(概况)
 * @author: huanghz
 * @date: 2019/9/5 下午 04:19
 */
public class NioTest05
{
    public static void main(String[] args)
    {
        ByteBuffer byteBuffer = ByteBuffer.allocate(64);

        byteBuffer.putInt(15);
        byteBuffer.putLong(500000L);
        byteBuffer.putDouble(14.33);
        byteBuffer.putChar('你');
        byteBuffer.putShort((short) 2);
        byteBuffer.putChar('我');

        byteBuffer.flip();

        System.out.println(byteBuffer.getInt());
        System.out.println(byteBuffer.getLong());
        System.out.println(byteBuffer.getDouble());
        System.out.println(byteBuffer.getChar());
        System.out.println(byteBuffer.getShort());
        System.out.println(byteBuffer.getChar());
    }
}
