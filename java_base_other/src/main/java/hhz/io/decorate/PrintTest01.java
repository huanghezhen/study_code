package hhz.io.decorate;

import java.io.*;

/**
 * @ClassName: PrintTest01
 * @Description: 打印流
 * @author: huanghz
 * @date: 2019/7/4 11:56
 */
public class PrintTest01
{
    public static void main(String[] args) throws Exception
    {
        PrintStream ps = System.out;
        ps.println("打印流");
        ps.println(true);
        ps.flush();

        // true 自动刷新
        ps = new PrintStream(new BufferedOutputStream(new FileOutputStream("hhz/data/PrintTest01.txt")),true);
        ps.println("hhhhhhh");
        ps.println(true);

        System.setOut(ps);
        System.out.println("qqqq");

        ps = new PrintStream(new BufferedOutputStream(new FileOutputStream(FileDescriptor.out)),true);
        System.setOut(ps);
        System.out.println("vvvv");

        ps.close();
    }
}
