package hhz.io.commons;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.net.URL;

/**
 * @ClassName: CIOTest05
 * @Description: TODO
 * @author: huanghz
 * @date: 2019/7/4 16:34
 */
public class CIOTest05
{
    public static void main(String[] args) throws Exception
    {
        // 复制文件
        FileUtils.copyFile(new File("hhz/data/CIOTest03.txt"), new File("hhz/data/CIOTest05.txt"));
        // 复制文件到目录
        FileUtils.copyFileToDirectory(new File("hhz/data/CIOTest05.txt"), new File("hhz/data/dir01"));
        // 复制目录到目录（包括目录）
        FileUtils.copyDirectoryToDirectory(new File(""),new File(""));
        // 复制目录（只包括内容）
        FileUtils.copyDirectory(new File(""),new File(""));
        // 复制网络内容
        FileUtils.copyURLToFile(new URL("http://www.baidu.com"),new File(""));
        String string = IOUtils.toString(new URL("http://www.baidu.com"), "utf-8");
    }
}
