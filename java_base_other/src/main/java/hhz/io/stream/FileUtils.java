package hhz.io.stream;

import java.io.*;

/**
 * @ClassName: FileUtils
 * @Description: 封装 copy和释放
 * @author: huanghz
 * @date: 2019/7/3 21:07
 */
public class FileUtils
{
    public static void main(String[] args)
    {
        try
        {
            InputStream is = new FileInputStream("hhz/data/iotest03.txt");
            OutputStream os = new FileOutputStream("hhz/data/iotest03-copy.txt");
            copy(is, os);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * 对接输入 输出
     *
     * @param is
     * @param os
     */
    public static void copy(InputStream is, OutputStream os)
    {
        try
        {
            // 读取和写入
            byte[] flush = new byte[1024];
            int len = -1;
            while ((len = is.read(flush)) != -1)
            {
                os.write(flush, 0, len);
            }
            os.flush();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            close(is, os);
        }
    }

    public static void close1(InputStream is, OutputStream os)
    {
        try
        {
            // 关闭
            if (os != null)
            {
                os.close();
            }

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

    public static void close(Closeable... io)
    {
        try
        {
            for (Closeable closeable : io)
            {
                // 关闭
                if (closeable != null)
                {
                    closeable.close();
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
