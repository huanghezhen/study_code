package hhz.demo12.nio;

import java.nio.ByteBuffer;

/**
 * @ClassName: NioTest07
 * @Description: TODO(概况)
 * @author: huanghz
 * @date: 2019/9/5 下午 04:41
 */
public class NioTest07
{
    public static void main(String[] args)
    {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        for (int i = 0; i < buffer.capacity(); i++)
        {
            buffer.put((byte) i);
        }

        ByteBuffer asReadOnlyBuffer = buffer.asReadOnlyBuffer();

        System.out.println(asReadOnlyBuffer.getClass());

        asReadOnlyBuffer.position(0);
        //asReadOnlyBuffer.put((byte) 2);
    }
}
