package hhz.io.file;

import java.io.File;

/**
 * @ClassName: FileDemo02
 * @Description: TODO
 * @author: huanghz
 * @date: 2019/7/3 11:00
 */
public class FileDemo02
{
    public static void main(String[] args)
    {
        // 绝对路径
        String path1 = "D:/huanghz/life/att/bigws/workspaces/hhz/data/qilongzhu.jpeg";
        File src = new File(path1);
        System.out.println(src.getAbsolutePath());

        // 相对路径
        System.out.println(System.getProperty("user.dir"));
        src = new File("hhz/data/qilongzhu.jpeg");
        System.out.println(src.length());

    }
}
