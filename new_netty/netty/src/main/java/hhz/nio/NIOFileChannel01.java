package hhz.nio;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @ClassName: NIOFileChannel01
 * @Description: TODO(概况)
 * @author: huanghz
 * @date: 2019/11/24 13:05
 */
public class NIOFileChannel01 {
    public static void main(String[] args) throws Exception {
        String str = "hello hhz";
        FileOutputStream fileOutputStream = new FileOutputStream("netty/data/file01.txt");

        FileChannel fileChannel = fileOutputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.put(str.getBytes());

        byteBuffer.flip();

        fileChannel.write(byteBuffer);
        fileOutputStream.close();
    }
}
