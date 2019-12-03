package hhz.singleresponsibility;

/**
 * huanghz
 * 2019/12/3 下午1:38
 */
public class SingleResponsibility1 {
    public static void main(String[] args) throws Exception {
        Vehicle vehicle = new Vehicle();

        vehicle.run("摩托车");
        vehicle.run("汽车");
        vehicle.run("飞机");
    }
}


class Vehicle {
    public void run(String vehicle) {
        System.out.println(vehicle + "在公路上运行.....");
    }
}