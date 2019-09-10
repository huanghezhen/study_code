package hhz.demo12.nio;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/**
 * @ClassName: NioTest13Server
 * @Description: TODO(概况)
 * @author: huanghz
 * @date: 2019/9/9 上午 09:58
 */
public class NioTest13Server
{
    private static Map<String, SocketChannel> clientMap = new HashMap<>();
    public static void main(String[] args) throws Exception
    {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        ServerSocket serverSocket = serverSocketChannel.socket();
        serverSocket.bind(new InetSocketAddress(8899));

        Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true)
        {
            selector.select();
            Set<SelectionKey> selectionKeys = selector.selectedKeys();

            for (SelectionKey selectionKey : selectionKeys)
            {
                if (selectionKey.isAcceptable())
                {
                    ServerSocketChannel server = (ServerSocketChannel) selectionKey.channel();
                    SocketChannel client = server.accept();
                    client.configureBlocking(false);
                    client.register(selector, SelectionKey.OP_READ);
                    String key = "[" + UUID.randomUUID().toString() + "]";
                    clientMap.put(key, client);
                }
                else if (selectionKey.isReadable())
                {
                    SocketChannel client = (SocketChannel) selectionKey.channel();
                    ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                    int count = client.read(readBuffer);
                    if (count > 0)
                    {
                        readBuffer.flip();
                        String receivedMessage = new String(readBuffer.array(),0,count);
                        System.out.println(client + ":" + receivedMessage);

                        String senderKey = null;
                        for (Map.Entry<String, SocketChannel> entry : clientMap.entrySet())
                        {
                            if (client == entry.getValue())
                            {
                                senderKey = entry.getKey();
                                break;
                            }
                        }

                        for (Map.Entry<String, SocketChannel> entry : clientMap.entrySet())
                        {
                            SocketChannel value = entry.getValue();
                            ByteBuffer wf = ByteBuffer.allocate(1024);
                            wf.put((senderKey+": "+receivedMessage).getBytes());
                            wf.flip();
                            value.write(wf);
                        }
                    }
                }
            }

            selectionKeys.clear();
        }

    }
}
