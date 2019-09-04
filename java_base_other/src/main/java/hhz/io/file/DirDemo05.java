package hhz.io.file;

import java.io.File;

/**
 * @ClassName: DirDemo05
 * @Description: TODO
 * @author: huanghz
 * @date: 2019/7/3 12:53
 */
public class DirDemo05
{
    // 文件大小
    private long len;
    // 文件内包含的文件数
    private int  fileNum;
    // 文件内包含的文件夹数
    private int  dirNum;

    public DirDemo05(File file)
    {
        // 在new类的时候，就统计大小
        count(file);
    }

    public long getLen()
    {
        return len;
    }

    public int getFileNum()
    {
        return fileNum;
    }

    public int getDirNum()
    {
        return dirNum;
    }

    private void count(File src)
    {
        if (src.exists())
        {
            if (src.isFile())
            {
                fileNum++;
                len += src.length();
            }
            else
            {
                dirNum++;
                for (File file : src.listFiles())
                {
                    count(file);
                }
            }
        }
    }

    public static void main(String[] args)
    {
        File file = new File("D:/huanghz/life/att/bigws/workspaces/hhz/src");
        DirDemo05 dirDemo05 = new DirDemo05(file);
        System.out.println(dirDemo05.getLen());
        System.out.println(dirDemo05.getFileNum());
        System.out.println(dirDemo05.getDirNum());
    }
}
