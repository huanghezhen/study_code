package hhz.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

/**
 * @ClassName: NIOFileChannel04
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/11/25 9:45
 */
public class NIOFileChannel04 {
    public static void main(String[] args) throws Exception {
        FileInputStream fileInputStream = new FileInputStream("netty/data/test03.jpg");
        FileOutputStream fileOutputStream = new FileOutputStream("netty/data/test04.jpg");

        FileChannel fileChannel01 = fileInputStream.getChannel();
        FileChannel fileChannel02 = fileOutputStream.getChannel();

        fileChannel02.transferFrom(fileChannel01, 0, fileChannel01.size());


        fileChannel02.close();
        fileChannel01.close();
        fileOutputStream.close();
        fileInputStream.close();

    }
}
