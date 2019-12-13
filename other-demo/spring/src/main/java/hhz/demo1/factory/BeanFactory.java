package hhz.demo1.factory;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @ClassName: BeanFactory
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/13 14:45
 */
public class BeanFactory {
    private static Map<String, Object> beans;
    static {
        try {
            Properties props = new Properties();
            InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            props.load(in);
            beans = new HashMap<>();
            Enumeration<Object> keys = props.keys();
            while (keys.hasMoreElements()) {
                String key = keys.nextElement().toString();
                String beanPath = props.getProperty(key);
                Object value = Class.forName(beanPath).newInstance();
                beans.put(key, value);
            }
        } catch (Exception e) {
            throw new ExceptionInInitializerError("初始化配置文件失败");
        }
    }

    public static Object getBean(String beanName) {
        return beans.get(beanName);
    }

/*    public static Object getBean(String beanName) {
        String beanPath = props.getProperty(beanName);
        Object bean = null;
        try {
            bean = Class.forName(beanPath).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }*/
}
