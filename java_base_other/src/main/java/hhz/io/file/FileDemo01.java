package hhz.io.file;

import java.io.File;

/**
 * @ClassName: FileDemo01
 * @Description: TODO
 * @author: huanghz
 * @date: 2019/7/3 10:52
 */
public class FileDemo01
{
    public static void main(String[] args)
    {
        String path1 = "D:/huanghz/life/att/bigws/workspaces/hhz/data/qilongzhu.jpeg";
        // 1 创建文件
        File src = new File(path1);
        // 输出长度(字节长度)
        System.out.println(src.length());

        // 2
        src = new File("D:/huanghz/life/att/bigws/workspaces/hhz/data","qilongzhu.jpeg");

        // 3
        src = new File(new File("D:/huanghz/life/att/bigws/workspaces/hhz/data"),"qilongzhu.jpeg");

    }
}
