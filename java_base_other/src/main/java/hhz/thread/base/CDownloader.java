package hhz.thread.base;

import java.util.concurrent.*;

/**
 * @ClassName: TDownloader
 * @Description: TODO
 * @author: huanghz
 * @date: 2019/7/5 10:19
 */
public class CDownloader implements Callable<Boolean>
{
    private String url;
    private String name;

    public CDownloader(String url, String name)
    {
        this.url = url;
        this.name = name;
    }

    @Override
    public Boolean call() throws Exception
    {
        WebDownloader wd = new WebDownloader();
        wd.download(url,name);

        return true;
    }

    public static void main(String[] args)
    {
        String url01 = "http://106.15.237.195:8000/upload/2019/7/qilongzhu-a698478d03fc407aaae81ad3bf788964.jpeg";
        String url02 = "http://106.15.237.195:8000/upload/2019/7/2-e064694da1f5489d8bef7b205b68d988.PNG";
        String url03 = "http://106.15.237.195:8000/upload/2019/7/1-93d939fe4066417ab1ed7a98feeaca69.PNG";
        CDownloader downloader01 = new CDownloader(url01,"hhz/data/td01.jpeg");
        CDownloader downloader02 = new CDownloader(url02,"hhz/data/td02.PNG");
        CDownloader downloader03 = new CDownloader(url03,"hhz/data/td03.PNG");


        // 创建执行服务
        ExecutorService ser = Executors.newFixedThreadPool(3);
        // 提交执行
        Future<Boolean> ret1 = ser.submit(downloader01);
        Future<Boolean> ret2 = ser.submit(downloader02);
        Future<Boolean> ret3 = ser.submit(downloader03);
        try
        {
            // 获取结果
            Boolean r1 = ret1.get();
            Boolean r2 = ret2.get();
            Boolean r3 = ret3.get();
            // 关闭服务
            ser.shutdownNow();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
