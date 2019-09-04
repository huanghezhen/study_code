package hhz.io.decorate;

import java.io.*;

/**
 * @ClassName: BufferedTest02
 * @Description: 字节 加入缓冲流
 * @author: huanghz
 * @date: 2019/7/4 9:51
 */
public class BufferedTest02
{
    public static void main(String[] args)
    {
        // 创建源
        File file = new File("hhz/data/iotest03.txt");
        OutputStream os = null;
        try
        {
            // 选择流
            os = new BufferedOutputStream(new FileOutputStream(file, true));
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
