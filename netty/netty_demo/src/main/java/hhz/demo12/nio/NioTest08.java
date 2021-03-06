package hhz.demo12.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @ClassName: NioTest08
 * @Description: TODO(概况)
 * @author: huanghz
 * @date: 2019/9/5 下午 04:53
 */
public class NioTest08
{
    public static void main(String[] args) throws Exception
    {
        FileInputStream inputStream = new FileInputStream("netty_demo/data/NioTest08_input.txt");
        FileOutputStream outputStream = new FileOutputStream("netty_demo/data/NioTest08_output.txt");

        FileChannel inputStreamChannel = inputStream.getChannel();
        FileChannel outputStreamChannel = outputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(512);

        while (true)
        {
            byteBuffer.clear();
            int read = inputStreamChannel.read(byteBuffer);

            System.out.println("read: " + read);

            if (-1 == read)
            {
                break;
            }
            byteBuffer.flip();
            outputStreamChannel.write(byteBuffer);
        }
        inputStream.close();
        outputStream.close();
    }
}
