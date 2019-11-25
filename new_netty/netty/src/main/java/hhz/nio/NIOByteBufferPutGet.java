package hhz.nio;

import java.nio.ByteBuffer;

/**
 * @ClassName: NIOByteBufferPutGet
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/11/25 10:05
 */
public class NIOByteBufferPutGet {
    public static void main(String[] args) throws Exception {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.putInt(20);
        byteBuffer.putChar('哈');

        byteBuffer.flip();

        System.out.println(byteBuffer.getInt());
        System.out.println(byteBuffer.getChar());
    }
}
