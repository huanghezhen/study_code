package hhz.io.decorate;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 * @ClassName: BufferedTest04
 * @Description: 字符 加入缓冲流
 * @author: huanghz
 * @date: 2019/7/4 10:11
 */
public class BufferedTest04
{
    public static void main(String[] args)
    {
        BufferedWriter writer = null;
        try
        {
            // 文件
            File file = new File("hhz/data/iotest06.txt");

            // 选择流
            writer = new BufferedWriter(new FileWriter(file));

            writer.append("hhhh llll");
            // 添加换行符 是 BufferedWriter 里面的方法
            writer.newLine();
            writer.append("qqqq,aaaaa");
            writer.flush();
            /*// 读取
            String str = "hhh,哈哈哈哈";
            writer.write(str);
            writer.flush();*/
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
