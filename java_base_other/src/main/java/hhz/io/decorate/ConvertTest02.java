package hhz.io.decorate;

import java.io.*;
import java.net.URL;

/**
 * @ClassName: ConvertTest01
 * @Description: 转换流
 * @author: huanghz
 * @date: 2019/7/4 10:38
 * <p>
 * InputStreamReader  OutputStreamWriter
 * 1 以字符流的形式操作字节流 （纯文本的）
 * 2 指定字符集
 */
public class ConvertTest02
{
    public static void main(String[] args)
    {
       // test01();
        test02();

    }

    /**
     * 使用字节流一个一个字节读取会出现 中文乱码
     */
    public static void test01()
    {
        // 操作system.in system.out
        try (InputStream inputStream = new URL("http://www.baidu.com").openStream();)
        {
            int tmp;
            while ((tmp = inputStream.read()) != -1)
            {
                System.out.print((char) tmp);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * 将字节流转为字符流 并加上缓冲流
     */
    public static void test02()
    {
        // 操作system.in system.out
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new URL("http://www.baidu.com").openStream()));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("hhz/data/baidu.html")))
        )
        {
            String line = "";
            while ((line = reader.readLine()) != null)
            {
                writer.append(line);
                writer.newLine();
            }
            writer.flush();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
