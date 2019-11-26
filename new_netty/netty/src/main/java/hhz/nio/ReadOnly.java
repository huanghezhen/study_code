package hhz.nio;

import java.nio.ByteBuffer;

/**
 * @ClassName: ReadOnly
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/11/25 10:09
 */
public class ReadOnly {
    public static void main(String[] args) throws Exception {
        ByteBuffer byteBuffer = ByteBuffer.allocate(64);

        for (int i = 0; i < byteBuffer.capacity(); i++) {
            byteBuffer.put((byte) i);
        }

        byteBuffer.flip();

        ByteBuffer readOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        System.out.println(readOnlyBuffer.getClass());


        while (readOnlyBuffer.hasRemaining()) {
            System.out.println(readOnlyBuffer.get());
        }

        // readOnlyBuffer.put((byte) 1);

    }
}
