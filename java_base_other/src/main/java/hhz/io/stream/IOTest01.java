package hhz.io.stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName: IOTest01
 * @Description: TODO
 * @author: huanghz
 * @date: 2019/7/3 15:03
 */
public class IOTest01
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

        // 1 创建源
        File file = new File("hhz/data/iotest02.txt");
        InputStream is = null;
        try
        {
            // 2 选择流
            is = new FileInputStream(file);

            // 3 读取(分段读取)
            // 缓冲容器
            byte[] car = new byte[3];
            // 接收长度
            int len = -1;
            // 开始读取
            while ((len = is.read(car)) != -1)
            {
                // 解码
                String str = new String(car,0,len);
                System.out.print(str);
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
                    // 4 释放
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
