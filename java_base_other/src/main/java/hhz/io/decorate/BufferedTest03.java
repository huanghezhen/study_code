package hhz.io.decorate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * @ClassName: BufferedTest03
 * @Description: 字符 加入缓冲流
 * @author: huanghz
 * @date: 2019/7/4 10:11
 */
public class BufferedTest03
{
    public static void main(String[] args)
    {
        BufferedReader is = null;
        try
        {
            // 文件
            File file = new File("hhz/data/iotest05.txt");

            // 选择流
            is = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = is.readLine()) != null)
            {
                System.out.println(line);
            }
           /* // 读取
            char[] flush = new char[1024];
            int len = -1;
            while ((len = is.read(flush)) != -1)
            {
                String str = new String(flush, 0, len);
                System.out.println(str);
            }*/


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
