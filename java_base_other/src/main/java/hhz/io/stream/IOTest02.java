package hhz.io.stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName: IOTest02
 * @Description: TODO
 * @author: huanghz
 * @date: 2019/7/3 15:03
 */
public class IOTest02
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
            is = new FileInputStream(file);

            // 读取
            int temp;
            while ((temp = is.read()) != -1)
            {
                System.out.print((char) temp);
            }

            /*// 读取
            int data1 = is.read();
            int data2 = is.read();
            int data3 = is.read();
            int data4 = is.read();
            System.out.println((char) data1);
            System.out.println((char) data2);
            System.out.println((char) data3);
            System.out.println(data4);*/

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
}
