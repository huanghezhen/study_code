package hhz.io.decorate;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @ClassName: ConvertTest01
 * @Description: 转换流
 * @author: huanghz
 * @date: 2019/7/4 10:38
 *
 * InputStreamReader  OutputStreamWriter
 * 1 以字符流的形式操作字节流 （纯文本的）
 * 2 指定字符集
 */
public class ConvertTest01
{
    public static void main(String[] args)
    {
        // 操作system.in system.out
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));)
        {
            String msg = "";
            while (!"exit".equals(msg))
            {
                msg = reader.readLine();
                writer.write(msg);
                writer.newLine();
                // 需要刷新 很重要
                writer.flush();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
