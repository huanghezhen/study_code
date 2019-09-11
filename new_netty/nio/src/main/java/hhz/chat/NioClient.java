package hhz.chat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * @ClassName: NioClient
 * @Description: TODO(概况)
 * @author: huanghz
 * @date: 2019/9/11 上午 10:22
 */
public class NioClient
{

    private void start() throws Exception
    {
        // 1. 连接服务端
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("127.0.0.1", 8000));

        // 2. 接收服务端响应 (开启新的线程)

        Selector selector = Selector.open();
        socketChannel.configureBlocking(false);
        socketChannel.register(selector, SelectionKey.OP_READ);
        new Thread(() -> {
            try
            {
                while (true)
                {
                    // 获取channel数量
                    int readyChannels = selector.select();
                    if (readyChannels > 0)
                    {
                        // 获取可用channel集合
                        Set<SelectionKey> selectionKeys = selector.selectedKeys();
                        Iterator<SelectionKey> iterator = selectionKeys.iterator();
                        while (iterator.hasNext())
                        {
                            SelectionKey selectionKey = iterator.next();
                            // 移除当前key
                            iterator.remove();

                            if (selectionKey.isReadable())
                            {
                                // 可读事件
                                // 1. selectionKey 获取channel
                                SocketChannel readChannel = (SocketChannel) selectionKey.channel();
                                // 2. 创建buffer
                                ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                                // 3. 循环读取服务端请求信息
                                StringBuilder response = new StringBuilder();
                                while (readChannel.read(byteBuffer) != 0)
                                {
                                    byteBuffer.flip();
                                    response.append(StandardCharsets.UTF_8.decode(byteBuffer));
                                    byteBuffer.clear();
                                }
                                // 4. 将channel再次注册到selector 监听可读事件
                                readChannel.register(selector, SelectionKey.OP_READ);
                                // 5. 输出服务器发出的信息
                                if (response.length() > 0)
                                {
                                    System.out.println(response.toString());
                                }
                            }

                        }
                    }
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }).start();

        // 3. 向服务端发送数据
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine())
        {
            String request = scanner.nextLine();
            if (request != null && request.length() > 0)
            {
                socketChannel.write(StandardCharsets.UTF_8.encode(request));
            }
        }
    }

    public static void main(String[] args) throws Exception
    {
        new NioClient().start();
    }
}
