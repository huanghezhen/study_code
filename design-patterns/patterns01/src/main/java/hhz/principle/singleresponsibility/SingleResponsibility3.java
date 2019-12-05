package hhz.principle.singleresponsibility;

/**
 * huanghz
 * 2019/12/3 下午1:50
 */
public class SingleResponsibility3 {
    public static void main(String[] args) throws Exception {
        Vehicle2 vehicle2 = new Vehicle2();

        vehicle2.run1("汽车");
        vehicle2.run2("飞机");
        vehicle2.run3("轮船");
    }
}


class Vehicle2 {
    public void run1(String vehicle) {
        System.out.println(vehicle + "在公路上运行.....");
    }

    public void run2(String vehicle) {
        System.out.println(vehicle + "在天空上运行.....");
    }


    public void run3(String vehicle) {
        System.out.println(vehicle + "在水中上运行.....");
    }
}