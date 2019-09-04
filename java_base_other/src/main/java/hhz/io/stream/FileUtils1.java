package hhz.io.stream;

import java.io.*;

/**
 * @ClassName: FileUtils
 * @Description: 封装 copy和释放
 * @author: huanghz
 * @date: 2019/7/3 21:07
 */
public class FileUtils1
{
    public static void main(String[] args)
    {
        try
        {
            copy("hhz/data/iotest03.txt", "hhz/data/iotest03-copy2.txt");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void copy(String path1, String path2)
    {
        try (InputStream is = new FileInputStream(path1);
             OutputStream os = new FileOutputStream(path2))
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
    }
}
