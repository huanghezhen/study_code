package hhz.flyweight;

import java.util.HashMap;

/**
 * @ClassName: WebSiteFactory
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/10 14:13
 */
public class WebSiteFactory {
    private HashMap<String, ConcreteWebSite> pool = new HashMap<>();

    public WebSite getWebSiteCategory(String type) {
        if (!pool.containsKey(type)) {
            pool.put(type, new ConcreteWebSite(type));
        }

        return pool.get(type);
    }

    public int getWebSiteCount() {
        return pool.size();
    }
}
