package hhz.thread.base;

/**
 * @ClassName: TDownloader
 * @Description: TODO
 * @author: huanghz
 * @date: 2019/7/5 10:19
 */
public class TDownloader extends Thread
{
    private String url;
    private String name;

    public TDownloader(String url, String name)
    {
        this.url = url;
        this.name = name;
    }

    @Override
    public void run()
    {
        WebDownloader wd = new WebDownloader();
        wd.download(url,name);
    }

    public static void main(String[] args)
    {
        String url01 = "http://106.15.237.195:8000/upload/2019/7/qilongzhu-a698478d03fc407aaae81ad3bf788964.jpeg";
        String url02 = "http://106.15.237.195:8000/upload/2019/7/2-e064694da1f5489d8bef7b205b68d988.PNG";
        String url03 = "http://106.15.237.195:8000/upload/2019/7/1-93d939fe4066417ab1ed7a98feeaca69.PNG";
        TDownloader tDownloader01 = new TDownloader(url01,"hhz/data/td01.jpeg");
        TDownloader tDownloader02 = new TDownloader(url02,"hhz/data/td02.PNG");
        TDownloader tDownloader03 = new TDownloader(url03,"hhz/data/td03.PNG");


        // 启动三个线程
        tDownloader01.start();
        tDownloader02.start();
        tDownloader03.start();
    }
}
