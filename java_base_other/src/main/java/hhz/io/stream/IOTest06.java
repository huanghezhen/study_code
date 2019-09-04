package hhz.io.stream;

import java.io.*;

/**
 * @ClassName: IOTest06
 * @Description: TODO
 * @author: huanghz
 * @date: 2019/7/3 17:42
 */
public class IOTest06
{
    public static void main(String[] args)
    {
        Writer writer = null;
        try
        {
            // 文件
            File file = new File("hhz/data/iotest06.txt");

            // 选择流
            writer = new FileWriter(file);
            // 读取
            String str = "hhh,哈哈哈哈";
            writer.write(str);

            // writer.write(char[]);
            // writer.append(char[]);
            writer.flush();
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
                if (writer != null)
                {
                    writer.close();
                }

            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
