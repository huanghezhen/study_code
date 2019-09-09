package hhz.demo12.nio;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @ClassName: NioTest02
 * @Description: TODO(概况)
 * @author: huanghz
 * @date: 2019/9/5 上午 10:24
 */
public class NioTest02
{
    public static void main(String[] args) throws Exception
    {
        FileInputStream fileInputStream = new FileInputStream("netty_demo/data/NioTest02.txt");
        FileChannel channel = fileInputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
        channel.read(byteBuffer);

        byteBuffer.flip();

        while (byteBuffer.hasRemaining())
        {
            byte b = byteBuffer.get();
            System.out.println("chat: " + (char) b);
        }

        fileInputStream.close();
    }
}
