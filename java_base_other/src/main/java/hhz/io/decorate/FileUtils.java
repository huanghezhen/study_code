package hhz.io.decorate;

import java.io.*;

/**
 * @ClassName: FileUtils
 * @Description: 对比使用缓冲流与不使用的区别
 * @author: huanghz
 * @date: 2019/7/3 21:07
 */
public class FileUtils
{
    public static void main(String[] args)
    {
        try
        {
            long t1 = System.currentTimeMillis();
            copy("hhz/data/qilongzhu.jpeg", "hhz/data/qilongzhu02.jpeg");
            long t2 = System.currentTimeMillis();
            System.out.println("不使用的时间为：" + (t2 - t1));

            long t3 = System.currentTimeMillis();
            copy("hhz/data/qilongzhu.jpeg", "hhz/data/qilongzhu03.jpeg");
            long t4 = System.currentTimeMillis();
            System.out.println("使用的时间为：" + (t4 - t3));

            // 因为文件太小，体现不出区别，但确实可以提高速度！
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

    public static void copyBuffered(String path1, String path2)
    {
        try (InputStream is = new BufferedInputStream(new FileInputStream(path1));
             OutputStream os = new BufferedOutputStream(new FileOutputStream(path2)))
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


    public static void copyBufferedChar(String path1, String path2)
    {
        try (BufferedReader is = new BufferedReader(new FileReader(path1));
             BufferedWriter os = new BufferedWriter(new FileWriter(path2)))
        {
            String line = null;
            while ((line = is.readLine()) != null)
            {
                os.append(line);
                os.newLine();
            }
            os.flush();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
