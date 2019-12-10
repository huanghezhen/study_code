package hhz.flyweight;

/**
 * @ClassName: ConcreteWebSite
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/10 14:12
 */
public class ConcreteWebSite extends WebSite {

    private String type;

    public ConcreteWebSite(String type) {
        this.type = type;
    }

    @Override
    public void use(User user) {
        System.out.println("网站发布形式"+type+" "+user.getName()+"使用中");
    }
}
