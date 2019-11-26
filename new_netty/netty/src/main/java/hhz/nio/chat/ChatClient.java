package hhz.nio.chat;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.Executors;

/**
 * @ClassName: ChatClinet
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/11/25 16:09
 */
public class ChatClient {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        SocketChannel socketChannel = SocketChannel.open();
        // 绑定服务端
        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 8888);
        socketChannel.connect(inetSocketAddress);
        socketChannel.configureBlocking(false);
        Selector selector = Selector.open();
        socketChannel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(1024));
        System.out.println("连接成功!");

        Executors.newSingleThreadExecutor().execute(() -> {
            while (true) {
                try {
                    if (selector.select(200) == 0) {
                        continue;
                    }
                    // 获取 selectionKeys
                    Set<SelectionKey> selectionKeys = selector.selectedKeys();
                    Iterator<SelectionKey> iterator = selectionKeys.iterator();
                    // 遍历 selectionKeys
                    while (iterator.hasNext()) {
                        // 获取 selectionKey
                        SelectionKey selectionKey = iterator.next();
                        // 判断 selectionKey 事件
                        if (selectionKey.isReadable()) {
                            // 当事件是 读 事件 的时候  获取数据

                            SocketChannel channel = (SocketChannel) selectionKey.channel();

                            // 获取绑定的内容
                            ByteBuffer byteBuffer = (ByteBuffer) selectionKey.attachment();
                            // 将数据读取到buffer
                            channel.read(byteBuffer);
                            // 将buffer打印出来
                            System.out.println( new String(byteBuffer.array()));
                            byteBuffer.clear();
                        }
                        // 将处理好的事件删除
                        iterator.remove();
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        while (true) {
            String str = scanner.nextLine();
            ByteBuffer buffer = ByteBuffer.wrap(str.getBytes());
            socketChannel.write(buffer);
        }
    }
}
