package hhz.io.commons;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @ClassName: CIOTest02
 * @Description: TODO
 * @author: huanghz
 * @date: 2019/7/4 15:36
 */
public class CIOTest02
{
    public static void main(String[] args) throws IOException
    {
        // 读取文件
        String msg = FileUtils.readFileToString(new File("hhz/data/CIOTest02.txt"),"UTF-8");
        System.out.println(msg);
        System.out.println("----------------");
        byte[] datas = FileUtils.readFileToByteArray(new File("hhz/data/CIOTest02.txt"));
        System.out.println(datas.length);
        System.out.println("----------------");
        // 逐行读取
        List<String> msgs = FileUtils.readLines(new File("hhz/data/CIOTest02.txt"),"UTF-8");
        for (String s : msgs)
        {
            System.out.println(s);
        }
        System.out.println("----------------");

        LineIterator it = FileUtils.lineIterator(new File("hhz/data/CIOTest02.txt"), "UTF-8");
        while (it.hasNext())
        {
            System.out.println(it.nextLine());
        }
        System.out.println("----------------");

    }
}
