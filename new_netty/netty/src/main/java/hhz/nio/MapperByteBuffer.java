package hhz.nio;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @ClassName: MapperByteBuffer
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/11/25 11:27
 */
public class MapperByteBuffer {
    public static void main(String[] args) throws Exception {
        // MapperByteBuffer 可以让文件直接在内存(堆外内存)中修改,操作系统不需要copy一次
        RandomAccessFile randomAccessFile = new RandomAccessFile("netty/data/test01.txt", "rw");
        FileChannel channel = randomAccessFile.getChannel();
        /*
        1. 使用读写模式
        2. 可以直接修改的起始位置
        3. 映射内存的大小
         */
        MappedByteBuffer mappedByteBuffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, 5);


        mappedByteBuffer.put(0, (byte) 'H');
        mappedByteBuffer.put(3, (byte) '9');

        randomAccessFile.close();
    }
}
