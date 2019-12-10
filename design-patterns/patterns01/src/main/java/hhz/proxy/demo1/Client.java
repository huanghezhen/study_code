package hhz.proxy.demo1;

/**
 * @ClassName: Client
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/10 15:31
 */
public class Client {
    public static void main(String[] args) throws Exception {
        new TeacherDaoProxy(new TeacherDao()).teach();
    }
}
