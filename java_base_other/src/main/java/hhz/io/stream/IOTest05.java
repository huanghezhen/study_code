package hhz.io.stream;

import java.io.*;

/**
 * @ClassName: IOTest05
 * @Description: TODO
 * @author: huanghz
 * @date: 2019/7/3 17:42
 */
public class IOTest05
{
    public static void main(String[] args)
    {
        Reader is = null;
        try
        {
            // 文件
            File file = new File("hhz/data/iotest05.txt");

            // 选择流
            is = new FileReader(file);
            // 读取
            char[] flush = new char[1024];
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
        finally
        {
            try
            {
                // 关闭
                if (is != null)
                {
                    is.close();
                }

            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
