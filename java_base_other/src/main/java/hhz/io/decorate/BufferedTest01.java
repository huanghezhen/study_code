package hhz.io.decorate;

import java.io.*;

/**
 * @ClassName: BufferedTest01
 * @Description: 字节 加入缓冲流
 * @author: huanghz
 * @date: 2019/7/4 9:51
 */
public class BufferedTest01
{
    public static void main(String[] args)
    {

 /*
        理解操作步骤
        1 创建源
        2 选择流
        3 操作
        4 释放资源
         */

        // 创建源
        File file = new File("hhz/data/iotest01.txt");
        InputStream is = null;
        try
        {
            // 选择流
            is = new BufferedInputStream(new FileInputStream(file));

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
        finally
        {
            try
            {
                if (is != null)
                {
                    // 释放
                    is.close();
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    public static void test1()
    {
         /*
        理解操作步骤
        1 创建源
        2 选择流
        3 操作
        4 释放资源
         */

        // 创建源
        File file = new File("hhz/data/iotest01.txt");
        InputStream is = null;
        BufferedInputStream bis = null;
        try
        {
            // 选择流
            is = new FileInputStream(file);
            bis = new BufferedInputStream(is);

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
        finally
        {
            try
            {
                if (is != null)
                {
                    // 释放
                    is.close();
                }

                if (bis != null)
                {
                    // 释放
                    bis.close();
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
