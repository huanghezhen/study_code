package hhz.demo13;

import java.io.FileInputStream;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

/**
 * @ClassName: NewClient
 * @Description: TODO(概况)
 * @author: huanghz
 * @date: 2019/9/10 上午 09:46
 */
public class NewClient
{
    public static void main(String[] args)throws  Exception
    {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(true);
        socketChannel.bind(new InetSocketAddress("localhost", 8899));

        String fileName = "";
        FileChannel fileChannel = new FileInputStream(fileName).getChannel();
        long startTime = System.currentTimeMillis();
        long transferCount = fileChannel.transferTo(0, fileChannel.size(), socketChannel);
        System.out.println("发送字节数: " + transferCount + ",耗时:" + (System.currentTimeMillis() - startTime));
        fileChannel.close();
    }
}
