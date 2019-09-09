package hhz.demo12.nio;

import java.nio.IntBuffer;
import java.security.SecureRandom;

/**
 * @ClassName: NioTest01
 * @Description: TODO(概况)
 * @author: huanghz
 * @date: 2019/9/5 上午 10:04
 */
public class NioTest01
{
    public static void main(String[] args)
    {
        IntBuffer buffer = IntBuffer.allocate(10);
        for (int i = 0; i < 5; i++)
        {
            int randomNumber = new SecureRandom().nextInt(20);
            buffer.put(randomNumber);
        }

        System.out.println("before flip limit: "+ buffer.limit());

        buffer.flip();

        System.out.println("after flip limit: "+ buffer.limit());

        System.out.println("enter while loop");

        while (buffer.hasRemaining())
        {

            System.out.println("position: "+buffer.position());
            System.out.println("limit: "+buffer.limit());
            System.out.println("capacity: "+buffer.capacity());

            System.out.println(buffer.get());
        }
    }
}
