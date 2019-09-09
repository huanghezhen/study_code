package hhz.demo12.nio;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Random;

/**
 * @ClassName: NioTest09
 * @Description: TODO(概况)
 * @author: huanghz
 * @date: 2019/9/5 下午 08:53
 */
public class NioTest09
{
    public static void main(String[] args) throws Exception
    {
        RandomAccessFile randomAccessFile = new RandomAccessFile("netty_demo/data/NioTest09.txt", "rw");
        FileChannel channel = randomAccessFile.getChannel();
        MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_WRITE, 0, 5);

        map.put(0, (byte) 'a');
        map.put(3, (byte) 'b');

        randomAccessFile.close();
    }
}
