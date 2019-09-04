package hhz.io.stream;

import java.io.ByteArrayOutputStream;

/**
 * @ClassName: IOTest07
 * @Description: TODO
 * @author: huanghz
 * @date: 2019/7/3 17:42
 */
public class IOTest08
{
    public static void main(String[] args)
    {
        // 创建源
        byte[] dest = null;
        // 字节流不需要手动close
        ByteArrayOutputStream baos = null;
        try
        {
            // 选择流
            baos = new ByteArrayOutputStream();
            String msg = "show me the code";
            byte[] datas = msg.getBytes();
            baos.write(datas,0,datas.length);
            baos.flush();
            dest = baos.toByteArray();
            System.out.println(dest.length);
            System.out.println(new String(dest,0,baos.size()));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
