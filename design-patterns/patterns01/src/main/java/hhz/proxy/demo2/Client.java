package hhz.proxy.demo2;

/**
 * @ClassName: Client
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/10 17:06
 */
public class Client {
    public static void main(String[] args) throws Exception {
        ITeacherDao target = new TeacherDao();

        ProxyFactory proxyFactory = new ProxyFactory(target);
        Object proxyInstance = proxyFactory.getProxyInstance();
        ITeacherDao proxyTarget = (ITeacherDao) proxyInstance;
        proxyTarget.teach();

    }
}
