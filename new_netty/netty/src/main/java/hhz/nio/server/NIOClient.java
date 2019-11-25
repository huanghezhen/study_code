package hhz.nio.server;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @ClassName: NIOClient
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/11/25 14:55
 */
public class NIOClient {
    public static void main(String[] args) throws Exception {
        // 得到网络通道
        SocketChannel socketChannel = SocketChannel.open();

        // 设置非阻塞
        socketChannel.configureBlocking(false);

        // 绑定服务端
        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 6666);
        if (!socketChannel.connect(inetSocketAddress)) {
            while (!socketChannel.finishConnect()) {
                System.out.println("正在连接,非阻塞,可以处理其他事情");
            }
        }

        System.out.println("连接成功开始,发送数据");
        // 连接成功 发送数据
        String str = "hhhhh";
        ByteBuffer buffer = ByteBuffer.wrap(str.getBytes());
        socketChannel.write(buffer);
        System.out.println("发送数据成功");


    }
}
