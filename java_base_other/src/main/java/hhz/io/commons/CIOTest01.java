package hhz.io.commons;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.EmptyFileFilter;

import java.io.File;
import java.util.Collection;

/**
 * @ClassName: CIOTest01
 * @Description: TODO
 * @author: huanghz
 * @date: 2019/7/4 15:11
 */
public class CIOTest01
{
    public static void main(String[] args)
    {
        // 文件大小
        long len = FileUtils.sizeOf(new File("hhz/data/RandTest03.txt"));
        System.out.println(len);

        // 目录的大小
        len = FileUtils.sizeOf(new File("hhz/data"));
        System.out.println(len);

        // 获取子文件
        Collection<File> files = FileUtils.listFiles(new File("hhz/data"), EmptyFileFilter.NOT_EMPTY, null);
        for (File file : files)
        {
            System.out.println(file.getAbsolutePath());
        }
        System.out.println("-----------------------");
        // 获取子孙文件
        files = FileUtils.listFiles(new File("hhz/data"), EmptyFileFilter.NOT_EMPTY, DirectoryFileFilter.INSTANCE);
        for (File file : files)
        {
            System.out.println(file.getAbsolutePath());
        }

    }
}
