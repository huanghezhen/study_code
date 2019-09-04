package hhz.io.decorate;

import java.io.File;
import java.io.RandomAccessFile;

/**
 * @ClassName: RandTest02
 * @Description: 随机读取和写入流 RandomAccessFile
 * @author: huanghz
 * @date: 2019/7/4 13:46
 */
public class RandTest02
{
    public static void main(String[] args)
    {
        test03("hhz/data/RandTest01.txt",2048);
    }

    public static void test03(String path,int size)
    {
        // 分多少块
        File file = new File(path);
        // 大小
        long len = file.length();

        // 多少块
        int all = (int) Math.ceil(len * 1.0 / size);

        int beginPos = 0;
        int blockSize = (int) (size > len ? len : size);

        for (int i = 0; i < all; i++)
        {
            beginPos = i * size;
            test02(i+1,beginPos, blockSize);
            System.out.println();
        }
    }

    public static void test02(int i,int beginPos, int blockSize)
    {
        try
        {
            RandomAccessFile raf = new RandomAccessFile(new File("hhz/data/RandTest01.txt"), "r");
            RandomAccessFile rafw = new RandomAccessFile(new File("hhz/data/RandTest02-"+i+".txt"), "rw");
            raf.seek(beginPos);
            byte[] flush = new byte[1024];
            int len = -1;
            while ((len = raf.read(flush)) != -1)
            {
                // 当读取的大小，小于想要的大小就使用读到的大小
                if (blockSize > len)
                {
                    rafw.write(flush,0,len);
                    blockSize -= len;
                }
                else
                {
                    // 当想要的大小小于等于读到的大小的时候，直接用想要的大小
                    rafw.write(flush,0,blockSize);
                    break;
                }
            }
            rafw.close();
            raf.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
