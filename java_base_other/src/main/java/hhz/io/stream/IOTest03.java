package hhz.io.stream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @ClassName: IOTest03
 * @Description: 文件字节输出流
 * @author: huanghz
 * @date: 2019/7/3 16:19
 */
public class IOTest03
{
    public static void main(String[] args)
    {
        // 创建源
        File file = new File("hhz/data/iotest03.txt");
        OutputStream os = null;
        try
        {
            // 选择流
            os = new FileOutputStream(file,true);
            // 写数据
            String msg = "IO is so easy";
            byte[] datas = msg.getBytes();
            os.write(datas,0,datas.length);
            os.flush();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if (os != null)
                {
                    os.close();
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
