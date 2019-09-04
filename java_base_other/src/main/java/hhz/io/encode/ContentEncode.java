package hhz.io.encode;

import java.io.UnsupportedEncodingException;

/**
 * @ClassName: ContentEncode
 * @Description: 字符串--》字节  编码
 * @author: huanghz
 * @date: 2019/7/3 14:29
 */
public class ContentEncode
{
    public static void main(String[] args) throws UnsupportedEncodingException
    {
        String msg = "性命生命使命a";
        // 编码字节数组
        byte[] datas = msg.getBytes();
        System.out.println("utf-8 字节数："+datas.length);

        datas = msg.getBytes("UTF-16LE");
        System.out.println("UTF-16LE 字节数："+datas.length);

        datas = msg.getBytes("GBK");
        System.out.println("GBK 字节数："+datas.length);
    }
}
