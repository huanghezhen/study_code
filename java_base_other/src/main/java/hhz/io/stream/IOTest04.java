package hhz.io.stream;

import java.io.*;

/**
 * @ClassName: IOTest04
 * @Description: 文件拷贝
 * @author: huanghz
 * @date: 2019/7/3 17:03
 */
public class IOTest04
{
    public static void main(String[] args)
    {

        InputStream is = null;
        OutputStream os = null;
        try
        {
            // 文件
            File file1 = new File("hhz/data/iotest03.txt");
            File file2 = new File("hhz/data/iotest04.txt");

            // 选择流
            is = new FileInputStream(file1);
            os = new FileOutputStream(file2);

            // 读取和写入
            byte[] flush = new byte[1024];
            int len = -1;
            while ((len = is.read(flush)) != -1)
            {
                os.write(flush,0,len);
            }
            os.flush();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }finally
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
    }
}
