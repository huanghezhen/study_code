package hhz.io.file;

import java.io.File;

/**
 * @ClassName: PathDemo01
 * @Description: TODO
 * @author: huanghz
 * @date: 2019/7/3 10:31
 */
public class PathDemo01
{
    public static void main(String[] args)
    {
        String path = "D:\\huanghz\\life\\att\\bigws\\workspaces\\hhz\\data\\qilongzhu.jpeg";
        System.out.println(File.separator);

        String sep = File.separator;
        // 建议
        // 1
        String path1 = "D:/huanghz/life/att/bigws/workspaces/hhz/data/qilongzhu.jpeg";
        // 2 常量拼接
        String path2 = "D:" + sep + "huanghz" + sep + "life" + sep + "att" + sep + "bigws" + sep + "workspaces" + sep + "hhz" + sep + "data" + sep
                + "qilongzhu.jpeg";
        System.out.println(path2);
    }
}
