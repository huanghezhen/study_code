package hhz.demo12.nio;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @ClassName: NioTest03
 * @Description: TODO(概况)
 * @author: huanghz
 * @date: 2019/9/5 上午 10:32
 */
public class NioTest03
{
    public static void main(String[] args) throws Exception
    {
        FileOutputStream fileOutputStream = new FileOutputStream("netty_demo/data/NioTest03.txt");
        FileChannel channel = fileOutputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(512);

        ByteBuffer put = byteBuffer.put("hhh".getBytes());

        put.flip();

        channel.write(put);

        fileOutputStream.close();
    }
}
