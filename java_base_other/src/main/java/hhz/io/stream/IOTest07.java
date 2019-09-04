package hhz.io.stream;

import java.io.*;

/**
 * @ClassName: IOTest07
 * @Description: TODO
 * @author: huanghz
 * @date: 2019/7/3 17:42
 */
public class IOTest07
{
    public static void main(String[] args)
    {
        // 创建源
        byte[] src = "talk is cheap show me the code".getBytes();
        // 字节流不需要手动close
        InputStream is = null;
        try
        {
            // 选择流
            is = new ByteArrayInputStream(src);
            byte[] flush = new byte[1024];
            int len = -1;
            while ((len = is.read(flush)) != -1)
            {
                String str = new String(flush, 0, len);
                System.out.println(str);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
