package hhz.nio.chat;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @ClassName: ChatServer
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/11/25 15:56
 */
public class ChatServer {
    public static void main(String[] args) throws Exception {
        // 新建 ServerSocketChannel
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        // 设置非阻塞
        serverSocketChannel.configureBlocking(false);
        // 绑定端口
        serverSocketChannel.bind(new InetSocketAddress(8888));

        // 新建 Selector
        Selector selector = Selector.open();
        // 将 ServerSocketChannel 注册到 Selector 上 并监听 OP_ACCEPT 事件
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        System.out.println("服务端启动成功!");
        // 循环监听事件
        while (true) {
            // 当事件为0 则继续   200ms 刷新一次
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
                if (selectionKey.isAcceptable()) {
                    // 当为 OP_ACCEPT 事件   从 serverSocketChannel 接受
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    // 设置为非阻塞
                    socketChannel.configureBlocking(false);
                    //添加监听 读事件,并附带 buffer
                    socketChannel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                    System.out.println("有新客户端连接! " + socketChannel.getRemoteAddress());
                } else if (selectionKey.isReadable()) {
                    // 当事件是 读 事件 的时候  获取数据
                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                    // 获取绑定的内容
                    ByteBuffer byteBuffer = (ByteBuffer) selectionKey.attachment();
                    // 将数据读取到buffer
                    socketChannel.read(byteBuffer);
                    // 将buffer打印出来
                    String str = "from " + socketChannel.getRemoteAddress() + " : " + new String(byteBuffer.array());
                    System.out.println(str);
                    byteBuffer.clear();

                    socketChannel.write(ByteBuffer.wrap(str.getBytes()));
                }
                // 将处理好的事件删除
                iterator.remove();
            }
        }
    }



}
