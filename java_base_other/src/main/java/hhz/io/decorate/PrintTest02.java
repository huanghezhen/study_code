package hhz.io.decorate;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;

/**
 * @ClassName: PrintTest02
 * @Description: 打印流
 * @author: huanghz
 * @date: 2019/7/4 11:56
 */
public class PrintTest02
{
    public static void main(String[] args) throws Exception
    {
        PrintWriter pw = new PrintWriter(new BufferedOutputStream(new FileOutputStream("hhz/data/PrintTest02.txt")), true);
        pw.println("hhhhee");
        pw.close();
    }
}
