package hhz.demo12.nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName: NioTest13Client
 * @Description: TODO(概况)
 * @author: huanghz
 * @date: 2019/9/9 下午 01:34
 */
public class NioTest13Client
{
    public static void main(String[] args) throws Exception
    {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);

        Selector selector = Selector.open();
        socketChannel.register(selector, SelectionKey.OP_CONNECT);
        socketChannel.connect(new InetSocketAddress("127.0.0.1", 8899));

        while (true)
        {
            selector.select();
            Set<SelectionKey> keySet = selector.selectedKeys();

            for (SelectionKey selectionKey : keySet)
            {
                if (selectionKey.isConnectable())
                {
                    SocketChannel client = (SocketChannel) selectionKey.channel();
                    if (client.isConnectionPending())
                    {
                        client.finishConnect();
                        ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
                        writeBuffer.put((LocalDateTime.now() + " 连接成功").getBytes());
                        writeBuffer.flip();
                        client.write(writeBuffer);

                        ExecutorService executorService = Executors.newSingleThreadExecutor(Executors.defaultThreadFactory());
                        executorService.submit(()->{
                            try
                            {
                                while (true)
                                {
                                    writeBuffer.clear();
                                    InputStreamReader inputStreamReader = new InputStreamReader(System.in);
                                    BufferedReader br = new BufferedReader(inputStreamReader);
                                    String sendMessage = null;
                                    sendMessage = br.readLine();
                                    writeBuffer.put(sendMessage.getBytes());
                                    writeBuffer.flip();
                                    client.write(writeBuffer);
                                }
                            }
                            catch (IOException e)
                            {
                                e.printStackTrace();
                            }

                        });
                    }
                    client.register(selector, SelectionKey.OP_READ);
                }
                else if (selectionKey.isReadable())
                {
                    SocketChannel client = (SocketChannel) selectionKey.channel();
                    ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                    int read = client.read(readBuffer);
                    if (read > 0)
                    {
                        readBuffer.flip();
                        String receivedMessage = new String(readBuffer.array(),0,read);
                        System.out.println(receivedMessage);
                    }
                }
            }
            keySet.clear();
        }

    }
}
