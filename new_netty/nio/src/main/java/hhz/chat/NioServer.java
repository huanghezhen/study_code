package hhz.chat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Set;

/**
 * @ClassName: NioServer
 * @Description: TODO(概况)
 * @author: huanghz
 * @date: 2019/9/11 上午 10:21
 */
public class NioServer
{
    private void start() throws Exception
    {
        // 1. 创建Selector
        Selector selector = Selector.open();
        // 2. 通过ServerSocketChannel创建channel通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        // 3. 为channel通道绑定监听端口
        serverSocketChannel.bind(new InetSocketAddress(8000));
        // 4. 设置channel为非阻塞模式
        serverSocketChannel.configureBlocking(false);
        // 5. 将channel注册到selector上,监听连接事件
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("服务器启动成功");
        // 6. 循环等待新的连接
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

                    if (selectionKey.isAcceptable())
                    {
                        // 接入事件
                        acceptHandler(selectionKey, selector);
                    }
                    else if (selectionKey.isReadable())
                    {
                        // 可读事件
                        readHandler(selectionKey, selector);
                    }

                }
            }
        }
        // 7. 根据就绪状态,调用对应的方法处理业务逻辑

    }

    // 接入事件
    private void acceptHandler(SelectionKey selectionKey, Selector selector) throws Exception
    {
        // 1. 创建socketChannel
        ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey.channel();
        SocketChannel socketChannel = serverSocketChannel.accept();
        // 2. 将socketChannel 设置为非阻塞模式
        socketChannel.configureBlocking(false);
        // 3. 将channel注册到selector上,监听可读事件
        socketChannel.register(selector, SelectionKey.OP_READ);
        // 4. 回复客户端
        socketChannel.write(StandardCharsets.UTF_8.encode("成功连接服务器!"));
    }

    // 可读事件
    private void readHandler(SelectionKey selectionKey, Selector selector) throws Exception
    {
        // 1. selectionKey 获取channel
        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
        // 2. 创建buffer
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        // 3. 循环读取客户端请求信息
        StringBuilder request = new StringBuilder();
        while (socketChannel.read(byteBuffer) != 0)
        {
            byteBuffer.flip();
            request.append(StandardCharsets.UTF_8.decode(byteBuffer));
        }
        // 4. 将channel再次注册到selector 监听可读事件
        socketChannel.register(selector, SelectionKey.OP_READ);
        // 5. 将客户端发送的信息,广播给其他客户端
        if (request.length() > 0)
        {
            broadCast(selector, socketChannel, request.toString());
        }
    }

    // 广播给其他客户端
    private void broadCast(Selector selector,SocketChannel sourceChannel,String request)
    {
        // 1. 获取所有接入的客户端channel
        Set<SelectionKey> selectionKeySet = selector.keys();
        // 2. 循环向所有channel广播信息
        selectionKeySet.forEach(selectionKey -> {
            Channel targetChannel = selectionKey.channel();
            // 获取非当前channel
            if (targetChannel instanceof SocketChannel && targetChannel != sourceChannel)
            {
                try
                {
                    // 发送消息
                    SocketChannel socketChannel = (SocketChannel) targetChannel;
                    socketChannel.write(StandardCharsets.UTF_8.encode(request));
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        });
    }

    public static void main(String[] args) throws Exception
    {
        new NioServer().start();
    }
}
