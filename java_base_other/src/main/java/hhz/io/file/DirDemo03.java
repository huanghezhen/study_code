package hhz.io.file;

import java.io.File;

/**
 * @ClassName: DirDemo03
 * @Description: TODO
 * @author: huanghz
 * @date: 2019/7/3 12:53
 */
public class DirDemo03
{


    public static void main(String[] args)
    {
        File file = new File("D:/huanghz/life/att/bigws/workspaces/hhz/src");
        count(file);
        System.out.println(len);
    }

    static long len = 0;
    public static void count(File src)
    {
        if (src.exists())
        {
            if (src.isFile())
            {
                len += src.length();
            }else
            {
                for (File file : src.listFiles())
                {
                    count(file);
                }
            }
        }
    }
}
