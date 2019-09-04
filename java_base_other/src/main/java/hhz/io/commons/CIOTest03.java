package hhz.io.commons;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: CIOTest03
 * @Description: TODO
 * @author: huanghz
 * @date: 2019/7/4 16:27
 */
public class CIOTest03
{
    public static void main(String[] args) throws IOException
    {
        FileUtils.write(new File("hhz/data/CIOTest03.txt"),"学习是件伟大的事情\r\n","UTF-8");
        FileUtils.writeStringToFile(new File("hhz/data/CIOTest03.txt"),"学习是件伟大的事情\r\n","UTF-8",true);
        FileUtils.writeByteArrayToFile(new File("hhz/data/CIOTest03.txt"),"学习是件伟大的事情\r\n".getBytes(),true);

        List<String> datas = new ArrayList<>();
        datas.add("mmm");
        datas.add("sss");
        datas.add("aaa");


        FileUtils.writeLines(new File("hhz/data/CIOTest03.txt"),datas,"-",true);
    }
}
