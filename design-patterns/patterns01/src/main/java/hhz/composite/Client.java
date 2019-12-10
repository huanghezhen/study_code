package hhz.composite;

/**
 * @ClassName: Client
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/10 9:28
 */
public class Client {
    public static void main(String[] args) throws Exception {
        OrganizationComponent university = new University("清华大学", "顶级");

        OrganizationComponent college1 = new College("计算机学院", "计算机学院");
        OrganizationComponent college2 = new College("信息工程学院", "信息工程学院");

        OrganizationComponent department1 = new Department("软件工程", "软件工程");
        OrganizationComponent department2 = new Department("网络工程", "网络工程");

        OrganizationComponent department3 = new Department("移动互联网", "移动互联网");
        OrganizationComponent department4 = new Department("通信", "通信");


        university.add(college1);
        university.add(college2);


        college1.add(department1);
        college1.add(department2);

        college2.add(department3);
        college2.add(department4);

        university.print();
    }
}
