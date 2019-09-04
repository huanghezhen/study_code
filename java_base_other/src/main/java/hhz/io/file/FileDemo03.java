package hhz.io.file;

import java.io.File;
import java.io.IOException;

/**
 * @ClassName: FileDemo03
 * @Description: TODO
 * @author: huanghz
 * @date: 2019/7/3 11:07
 */
public class FileDemo03
{
    public static void main(String[] args) throws IOException
    {
        File src = new File("hhz/data/qilongzhu.jpeg");
        //File src = new File("D:/huanghz/life/att/bigws/workspaces/hhz/data/qilongzhu.jpeg");

        System.out.println("名称: "+ src.getName());
        System.out.println("路径: "+ src.getPath());
        System.out.println("绝对路径: "+ src.getAbsolutePath());
        System.out.println("父路径: "+ src.getParent());
        System.out.println("父对象: "+ src.getParentFile().getName());


        System.out.println("是否存在: "+ src.exists());
        System.out.println("是否是文件: "+ src.isFile());
        System.out.println("是否是文件夹: "+ src.isDirectory());


        src = new File("XXX");
        if (src == null || !src.exists())
        {
            System.out.println("文件不存在");
        }else
        {
            if (src.isFile())
            {
                System.out.println("文件操作");
            }
            else if (src.isDirectory())
            {
                System.out.println("文件夹操作");
            }
        }

        String path1 = "D:/huanghz/life/att/bigws/workspaces/hhz/data/hhz.txt";
        File src1 = new File(path1);
        // 不存在则创建，存在不创建
        boolean newFile = src1.createNewFile();

        boolean delete = src1.delete();
        System.out.println(newFile);




    }
}
