package hhz.proxy.demo3;

/**
 * @ClassName: Client
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/10 17:20
 */
public class Client {
    public static void main(String[] args) throws Exception {
        ProxyFactory proxyFactory = new ProxyFactory(new TeacherDao());
        Object proxyInstance = proxyFactory.getProxyInstance();
        TeacherDao teacherDao = (TeacherDao) proxyInstance;
        teacherDao.teach();
    }
}
