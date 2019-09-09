package hhz.demo12.nio;

import java.nio.ByteBuffer;

/**
 * @ClassName: NioTest06
 * @Description: TODO(概况)
 * @author: huanghz
 * @date: 2019/9/5 下午 04:23
 */
public class NioTest06
{
    public static void main(String[] args)
    {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        for (int i = 0; i < buffer.capacity(); i++)
        {
            buffer.put((byte) i);
        }

        buffer.position(2);
        buffer.limit(6);

        ByteBuffer sliceBuffer = buffer.slice();

        for (int i = 0; i < sliceBuffer.capacity(); i++)
        {
            byte j = sliceBuffer.get(i);
            j *= 2;
            sliceBuffer.put(i, j);
        }

        buffer.position(0);
        buffer.limit(buffer.capacity());

        while (buffer.hasRemaining())
        {
            System.out.println(buffer.get());
        }
    }
}
