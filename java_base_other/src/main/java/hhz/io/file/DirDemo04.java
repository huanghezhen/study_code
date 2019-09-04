package hhz.io.file;

import java.io.File;

/**
 * @ClassName: DirDemo04
 * @Description: TODO
 * @author: huanghz
 * @date: 2019/7/3 12:53
 */
public class DirDemo04
{
    public static void main(String[] args)
    {
        File file = new File("D:/huanghz/life/att/bigws/workspaces/hhz/src");
        printName(file,0);
    }

    // 递归打印子孙级目录
    public static void printName(File src,int deep)
    {
        for (int i = 0; i < deep; i++)
        {
            System.out.print("  ");
        }
        System.out.println(src.getName());
        if (!src.exists())
        {
            // 如果不存在，直接返回
            return;
        }
        else if (src.isDirectory())
        {
            for (File file : src.listFiles())
            {
                printName(file,deep+1);
            }
        }
    }
}
