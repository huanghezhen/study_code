package hhz.demo12.nio;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @ClassName: NioTest12
 * @Description: TODO(概况)
 * @author: huanghz
 * @date: 2019/9/8 下午 03:10
 */
public class NioTest12
{
    public static void main(String[] args) throws Exception
    {
        int[] ports = new int[5];

        ports[0] = 5000;
        ports[1] = 5001;
        ports[2] = 5002;
        ports[3] = 5003;
        ports[4] = 5004;

        Selector selector = Selector.open();

        for (int port : ports)
        {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            ServerSocket serverSocket = serverSocketChannel.socket();
            InetSocketAddress address = new InetSocketAddress(port);
            serverSocket.bind(address);

            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

            System.out.println("监听端口: "+port);
        }

        while (true)
        {
            int number = selector.select();
            System.out.println("number: " + number);
            Set<SelectionKey> selectionKeys = selector.selectedKeys();

            System.out.println("selectionKeys: " + selectionKeys);

            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext())
            {
                SelectionKey next = iterator.next();
                if (next.isAcceptable())
                {
                    ServerSocketChannel channel = (ServerSocketChannel) next.channel();
                    SocketChannel accept = channel.accept();
                    accept.configureBlocking(false);
                    accept.register(selector, SelectionKey.OP_READ);
                    iterator.remove();
                    System.out.println("获得客户端连接: "+accept);
                }
                else if (next.isReadable())
                {
                    SocketChannel channel = (SocketChannel) next.channel();
                    int bytesRead = 0;
                    while (true)
                    {
                        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
                        byteBuffer.clear();

                        int read = channel.read(byteBuffer);

                        if (read <= 0)
                        {
                            break;
                        }
                        byteBuffer.flip();
                        channel.write(byteBuffer);
                        bytesRead += read;
                    }

                    System.out.println("读取: " + bytesRead + ",来自于: " + channel);
                    iterator.remove();
                }
            }
        }


    }
}
