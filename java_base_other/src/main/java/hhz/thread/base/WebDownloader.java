package hhz.thread.base;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @ClassName: WebDownloader
 * @Description: TODO
 * @author: huanghz
 * @date: 2019/7/5 10:17
 */
public class WebDownloader
{
    public void download(String url, String name)
    {
        try
        {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
