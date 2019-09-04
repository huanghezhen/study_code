package hhz.io.file;

import java.io.File;

/**
 * @ClassName: DirDemo02
 * @Description: TODO
 * @author: huanghz
 * @date: 2019/7/3 12:46
 */
public class DirDemo02
{
    public static void main(String[] args)
    {
        File dir01 = new File("D:/huanghz/life/att/bigws/workspaces/hhz/data");

        // 下一级文件名称
        String[] list = dir01.list();
        for (String s : list)
        {
            System.out.println(s);
        }

        // 下一级文件
        File[] files = dir01.listFiles();
        for (File file : files)
        {
            System.out.println(file.getAbsolutePath());
        }

        // 盘符
        System.out.println();
        File[] files1 = dir01.listRoots();
        for (File file : files1)
        {
            System.out.println(file.getAbsolutePath());
        }

    }
}
