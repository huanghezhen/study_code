package hhz.io.stream;

import java.io.*;

/**
 * @ClassName: IOTest09
 * @Description: TODO
 * @author: huanghz
 * @date: 2019/7/3 20:40
 */
public class IOTest09
{
    public static void main(String[] args)
    {
        InputStream is = null;
        OutputStream os = null;
        try
        {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            File file = new File("hhz/data/qilongzhu.jpeg");
            is = new FileInputStream(file);

            byte[] flush = new byte[1024];
            int len = -1;
            // 将文件写入字节数组中
            while ((len = is.read(flush)) != -1)
            {
                baos.write(flush,0,len);
            }
            baos.flush();


            // 读取字节数组流
            byte[] fileByte = baos.toByteArray();
            ByteArrayInputStream bais = new ByteArrayInputStream(fileByte);
            File file01 = new File("hhz/data/qilongzhu01.jpeg");
            os = new FileOutputStream(file01);
            // 将字节数组流中的字节写入到另一个文件中
            while ((len = bais.read(flush)) != -1)
            {
                os.write(flush,0,len);
            }
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
