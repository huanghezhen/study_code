package hhz.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @ClassName: NIOFileChannel03
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/11/25 9:14
 */
public class NIOFileChannel03 {
    public static void main(String[] args) throws Exception {
        File file01 = new File("netty/data/test01.txt");
        File file02 = new File("netty/data/test02.txt");

        FileInputStream fileInputStream = new FileInputStream(file01);
        FileOutputStream fileOutputStream = new FileOutputStream(file02);
        FileChannel fileChannel01 = fileInputStream.getChannel();
        FileChannel fileChannel02 = fileOutputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(5);

        while (fileChannel01.read(byteBuffer) != -1) {
            byteBuffer.flip();
            fileChannel02.write(byteBuffer);
            byteBuffer.clear();
        }

        fileInputStream.close();
        fileOutputStream.close();
    }
}
