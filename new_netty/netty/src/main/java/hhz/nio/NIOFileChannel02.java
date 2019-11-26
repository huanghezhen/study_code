package hhz.nio;

import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @ClassName: NIOFileChannel02
 * @Description: TODO(概况)
 * @author: huanghz
 * @date: 2019/11/24 13:18
 */
public class NIOFileChannel02 {
    public static void main(String[] args) throws Exception {
        File file = new File("netty/data/file01.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        FileChannel fileChannel = fileInputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate((int) file.length());
        fileChannel.read(byteBuffer);

        System.out.println(new String(byteBuffer.array()));
        fileInputStream.close();
    }
}
