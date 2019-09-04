package hhz.io.encode;

import java.io.UnsupportedEncodingException;

/**
 * @ClassName: ContentDecode
 * @Description: 解码  字节 --》 字符
 * @author: huanghz
 * @date: 2019/7/3 14:36
 */
public class ContentDecode
{
    public static void main(String[] args) throws UnsupportedEncodingException
    {
        String msg = "性命生命使命a";
        // 编码 字节数组
        byte[] datas = msg.getBytes();

        // 解码
        msg = new String(datas,0,datas.length,"utf8");
        System.out.println(msg);


        // 解码
        msg = new String(datas,0,datas.length-1,"utf8");
        System.out.println(msg);

        // 解码  乱码
        msg = new String(datas,0,datas.length-1,"gbk");
        System.out.println(msg);
    }
}
