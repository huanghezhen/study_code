package hhz.io.file;

import java.io.File;

/**
 * @ClassName: DirDemo01
 * @Description: TODO
 * @author: huanghz
 * @date: 2019/7/3 12:33
 */
public class DirDemo01
{
    public static void main(String[] args)
    {
        /*
          创建目录
           mkdir()
           mkdirs()
         */
        File dir01 = new File("D:/huanghz/life/att/bigws/workspaces/hhz/data/dir01/hhh");
        // boolean mkdir = dir01.mkdir(); mkdir = false
        boolean mkdir = dir01.mkdirs();
        System.out.println(mkdir);

    }
}
