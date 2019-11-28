package hhz.netty.buf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.CharsetUtil;

/**
 * @ClassName: NettyByteBuf02
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/11/28 11:16
 */
public class NettyByteBuf02 {
    public static void main(String[] args) throws Exception {
        ByteBuf byteBuf = Unpooled.copiedBuffer("Hello world 还好", CharsetUtil.UTF_8);

        if (byteBuf.hasArray()) {
            byte[] content = byteBuf.array();
            System.out.println(new String(content, CharsetUtil.UTF_8));
        }

    }
}
