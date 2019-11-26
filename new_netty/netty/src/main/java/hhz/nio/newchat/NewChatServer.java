package hhz.nio.newchat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * @ClassName: NewChatServer
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/11/26 15:12
 */
public class NewChatServer {
    private Selector selector;
    private ServerSocketChannel serverSocketChannel;

    private NewChatServer() {
        try {
            System.out.println("服务端启动中...............");
            // 创建 serverSocketChannel
            serverSocketChannel = ServerSocketChannel.open();
            // 创建 selector
            selector = Selector.open();
            // 设置非阻塞
            serverSocketChannel.configureBlocking(false);
            // 绑定端口
            serverSocketChannel.socket().bind(new InetSocketAddress(8888));
            // 注册事件到 selector
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

            System.out.println("服务端启动成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void run() {
        try {
            while (true) {
                // 200毫秒一次刷新 没有事件继续循环
                if (selector.select(200) == 0){
                    continue;
                }
                // 获取监听到的事件
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                // 将事件转为迭代器
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                // 循环事件
                while (iterator.hasNext()) {
                    // 获取事件
                    SelectionKey selectionKey = iterator.next();
                    // 判断事件类型
                    if (selectionKey.isAcceptable()) {
                        // 如果是 连接事件
                        // 获取 channel
                        SocketChannel socketChannel = serverSocketChannel.accept();
                        // 将channel设置为异步
                        socketChannel.configureBlocking(false);
                        // 将该channel注册 读事件
                        socketChannel.register(selector, SelectionKey.OP_READ);
                        // 拼接收到的信息
                        String on = socketChannel.getRemoteAddress().toString().substring(1) + " 上线!";
                        // 发送给其他服务器
                        broadcast(on, socketChannel);
                        // 打印数据
                        System.out.println(on);
                    } else if (selectionKey.isReadable()) {
                        // 处理读事件
                        read(selectionKey);
                    }
                    // 删除处理完的事件 否则会重复处理事件
                    iterator.remove();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void read(SelectionKey selectionKey) {
        // 获取channel
        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
        try {
            // 创建 StringBuilder 来拼接字符串
            StringBuilder stringBuilder = new StringBuilder();
            // 创建默认大小为 1024 的 buffer
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            // 拼接字符串(哪个服务器)
            stringBuilder.append(socketChannel.getRemoteAddress().toString().substring(1))
                    .append("说: ");
            // 循环接收 数据
            while (socketChannel.read(byteBuffer) != 0) {
                stringBuilder.append(new String(byteBuffer.array(),0,byteBuffer.position()));
                byteBuffer.clear();
            }
            // 发送给其他服务器
            broadcast(stringBuilder.toString(), socketChannel);
            // 打印数据
            System.out.println(stringBuilder.toString());
        } catch (Exception e) {
            try {
                // 如果在读 事件 接收到异常  说明该channel 下线
                String off = socketChannel.getRemoteAddress().toString().substring(1) + " 下线!";
                // 广播
                broadcast(off, socketChannel);
                // 打印数据
                System.out.println(off);
                // 这个地方必须取消 否则会一直处理数据
                selectionKey.channel();
                socketChannel.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }



    private void broadcast(String info, SocketChannel socketChannel) {
        try {
            // 通过 keys() 获取所有的channel
            Set<SelectionKey> keys = selector.keys();
            Iterator<SelectionKey> iterator = keys.iterator();
            while (iterator.hasNext()) {
                SelectionKey next = iterator.next();
                SelectableChannel channel = next.channel();
                // 判断 channel 是否是 SocketChannel 类型 并且不能是当前的channel
                if (channel instanceof SocketChannel && channel != socketChannel) {
                    // 将channel 转为 SocketChannel
                    SocketChannel send = (SocketChannel) channel;
                    // 发送数据
                    send.write(ByteBuffer.wrap(info.getBytes()));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws Exception {
        // 启动
        new NewChatServer().run();
    }
}
