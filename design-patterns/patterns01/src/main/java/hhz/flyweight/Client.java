package hhz.flyweight;

/**
 * @ClassName: Client
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/10 14:16
 */
public class Client {
    public static void main(String[] args) throws Exception {
        WebSiteFactory webSiteFactory = new WebSiteFactory();

        User user1 = new User();
        user1.setName("1111");

        User user2 = new User();
        user2.setName("2222");



        WebSite category = webSiteFactory.getWebSiteCategory("新闻");

        category.use(user1);

        category = webSiteFactory.getWebSiteCategory("博客");

        category.use(user1);

        category = webSiteFactory.getWebSiteCategory("新闻");

        category.use(user2);

        System.out.println(webSiteFactory.getWebSiteCount());

    }
}
