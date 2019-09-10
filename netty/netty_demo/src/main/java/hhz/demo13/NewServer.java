package hhz.demo13;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @ClassName: NewServer
 * @Description: TODO(概况)
 * @author: huanghz
 * @date: 2019/9/10 上午 09:47
 */
public class NewServer
{
    public static void main(String[] args) throws  Exception
    {
        InetSocketAddress address = new InetSocketAddress(8899);
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        ServerSocket serverSocket = serverSocketChannel.socket();
        serverSocket.setReuseAddress(true);
        serverSocket.bind(address);

        ByteBuffer byteBuffer = ByteBuffer.allocate(4096);
        while (true)
        {
            SocketChannel socketChannel = serverSocketChannel.accept();
            socketChannel.configureBlocking(true);

            int readCount = 0;
            while (-1 != readCount)
            {
                readCount = socketChannel.read(byteBuffer);
                byteBuffer.rewind();
            }
        }
    }
}
