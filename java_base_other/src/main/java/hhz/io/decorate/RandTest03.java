package hhz.io.decorate;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * @ClassName: RandTest02
 * @Description: 随机读取和写入流 RandomAccessFile
 * @author: huanghz
 * @date: 2019/7/4 13:46
 */
public class RandTest03
{

    private String path;
    private int size;
    private List<String> pathList;

    public RandTest03(String path, int size)
    {
        this.path = path;
        this.size = size;
        pathList = new ArrayList<>();
    }

    public String getPath()
    {
        return path;
    }

    public void setPath(String path)
    {
        this.path = path;
    }

    public int getSize()
    {
        return size;
    }

    public void setSize(int size)
    {
        this.size = size;
    }

    public void splitFile()
    {
        // 获取文件
        File file = new File(path);
        // 获取文件大小
        long len = file.length();
        // 根据每块的大小计算需要分多少块
        int all = (int) Math.ceil(len * 1.0 / size);
        // 定义开始位置
        int beginPos = 0;
        // 计算每块的大小
        int blockSize = (int) (size > len ? len : size);
        // 开始分割
        for (int i = 0; i < all; i++)
        {
            splitFile(i+1,i * size, blockSize,path);
        }
    }
    private void splitFile(int i,int beginPos,int blockSize,String path)
    {
        try
        {
            String[] paths = path.split("\\.");
            RandomAccessFile raf = new RandomAccessFile(new File(path), "r");
            String endPath = paths[0]+"-"+i+"."+paths[1];
            pathList.add(endPath);
            RandomAccessFile rafw = new RandomAccessFile(new File(endPath), "rw");
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

    public void merge(String destPath)
    {
        try
        {
            // 输入流
            OutputStream os = new BufferedOutputStream(new FileOutputStream(destPath, true));
            Vector<InputStream> vi = new Vector<>();
            SequenceInputStream sis = null;
            // 输入流
            for (String s : pathList)
            {
                vi.add(new BufferedInputStream(new FileInputStream(s)));
            }
            sis = new SequenceInputStream(vi.elements());
            byte[] flush = new byte[1024];
            int len = -1;
            while ((len = sis.read(flush)) != -1)
            {
                os.write(flush,0,len);
            }
            sis.close();
            os.flush();
            os.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    public static void main(String[] args)
    {
        RandTest03 randTest03 = new RandTest03("hhz/data/RandTest03.txt", 2048);
        randTest03.splitFile();
        randTest03.merge("hhz/data/merge.txt");
    }


}
