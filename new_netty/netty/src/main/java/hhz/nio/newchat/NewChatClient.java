package hhz.nio.newchat;

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
 * @ClassName: NewChatClient
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/11/26 15:12
 */
public class NewChatClient {
    private Selector selector;
    private SocketChannel socketChannel;
    private Scanner scanner;

    private NewChatClient() {
        try {
            System.out.println("客户端启动中...............");
            socketChannel = SocketChannel.open();
            selector = Selector.open();

            socketChannel.connect(new InetSocketAddress("127.0.0.1", 8888));
            socketChannel.configureBlocking(false);

            socketChannel.register(selector, SelectionKey.OP_READ);
            System.out.println("客户端启动结束,请输入内容:");
            scanner = new Scanner(System.in);
            read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void read() {
        Executors.newSingleThreadExecutor().execute(() -> {
            try {
                while (true) {
                    if (selector.select(200) == 0) {
                        continue;
                    }
                    Set<SelectionKey> selectionKeys = selector.selectedKeys();
                    Iterator<SelectionKey> iterator = selectionKeys.iterator();
                    while (iterator.hasNext()) {
                        SelectionKey next = iterator.next();
                        if (next.isReadable()) {
                            SocketChannel channel = (SocketChannel) next.channel();
                            // 创建 StringBuilder 来拼接字符串
                            StringBuilder stringBuilder = new StringBuilder();
                            // 创建默认大小为 1024 的 buffer
                            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                            // 循环接收 数据
                            while (channel.read(byteBuffer) != 0) {
                                stringBuilder.append(new String(byteBuffer.array(),0,byteBuffer.position()));
                                byteBuffer.clear();
                            }
                            // 打印数据
                            System.out.println(stringBuilder.toString());
                        }
                        iterator.remove();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }


    private void send() {
        try {
            while (true) {
                String str = scanner.nextLine();
                if (str.getBytes().length > 1024) {
                    System.out.println("警告: 如数字符串过长!");
                    continue;
                }
                ByteBuffer buffer = ByteBuffer.wrap(str.getBytes());
                socketChannel.write(buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws Exception {
        new NewChatClient().send();
    }
}
