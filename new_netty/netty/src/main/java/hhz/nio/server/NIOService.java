package hhz.nio.server;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * @ClassName: NIOService
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/11/25 14:28
 */
public class NIOService {
    public static void main(String[] args) throws Exception {

        // 创建serverSocketChannel
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        // 创建 Selector
        Selector selector = Selector.open();

        // 打开serverSocketChannel 并绑定端口
        serverSocketChannel.socket().bind(new InetSocketAddress(6666));

        // 设置非阻塞
        serverSocketChannel.configureBlocking(false);

        // 把serverSocketChannel 注册到 selector 关心的事件为 OP_ACCEPT
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        // 循环等待客户端的连接
        while (true) {
            if (selector.select(1000) == 0) {
                // 没有时间发生
                System.out.println(" 服务器等待了 1 秒,无连接");
            }else{
                // 返回关注事件的集合
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();

                while (iterator.hasNext()){
                    SelectionKey selectionKey = iterator.next();
                    // 判断selectionKey是什么事件
                    if (selectionKey.isAcceptable()) {
                        // 连接事件 生成一个socketChannel
                        SocketChannel socketChannel = serverSocketChannel.accept();
                        // 设置非阻塞
                        socketChannel.configureBlocking(false);
                        // 管联一个buffer
                        socketChannel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                    } else if (selectionKey.isReadable()) {
                        // 读事件 反向获取对应的channel
                        SocketChannel channel = (SocketChannel) selectionKey.channel();
                        // 获取该channel关联的buffer
                        ByteBuffer buffer = (ByteBuffer) selectionKey.attachment();
                        System.out.println("from 客户端:");
                        channel.read(buffer);
                        System.out.println(new String(buffer.array()));
                    }
                    // 删除当前key
                    iterator.remove();
                }
            }
        }

    }
}














