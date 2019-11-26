package hhz.nio;

import java.net.InetSocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

/**
 * @ClassName: ScatteringAndGathering
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/11/25 11:45
 */
public class ScatteringAndGathering {
    public static void main(String[] args) throws Exception {
        /*
        Scattering: 将数据写入到buffer时 可以采用buffer数组 依次写入
        Gathering: 从buffer读取数据时 可以采用buffer数组 依次读
         */

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        InetSocketAddress inetSocketAddress = new InetSocketAddress(7000);
        // 绑定端口
        serverSocketChannel.socket().bind(inetSocketAddress);

        ByteBuffer[] byteBuffers = new ByteBuffer[2];
        byteBuffers[0] = ByteBuffer.allocate(5);
        byteBuffers[1] = ByteBuffer.allocate(3);


        SocketChannel socketChannel = serverSocketChannel.accept();
        int messageLength = 8;


        while (true) {
            long byteRead = 0;
            while (byteRead < messageLength) {
                long read = socketChannel.read(byteBuffers);
                byteRead += read;
                System.out.println("读取的字节数byteRead: " + byteRead);
                System.out.println();

                // 使用流打印

                Arrays.stream(byteBuffers).map(buffer ->
                        "postion=" + buffer.position() + " , limit=" +buffer.limit()
                ).forEach(System.out::println);

            }

            // 将所有buffer反转
            Arrays.stream(byteBuffers).forEach(Buffer::flip);

            long byteWrite = 0;
            while (byteWrite < messageLength) {
                long write = socketChannel.write(byteBuffers);
                byteWrite += write;
            }

            Arrays.stream(byteBuffers).forEach(Buffer::clear);

            System.out.format("byteRead = %d , byteWrite = %d", byteRead, byteWrite);
        }
    }
}

























