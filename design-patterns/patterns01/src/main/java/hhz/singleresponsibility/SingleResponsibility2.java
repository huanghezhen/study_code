package hhz.singleresponsibility;

/**
 * huanghz
 * 2019/12/3 下午1:38
 */
public class SingleResponsibility2 {
    public static void main(String[] args) throws Exception {
        RoadVehicle roadVehicle = new RoadVehicle();

        roadVehicle.run("摩托车");
        roadVehicle.run("汽车");

        AirVehicle airVehicle = new AirVehicle();
        airVehicle.run("飞机");
    }
}


class RoadVehicle {
    public void run(String vehicle) {
        System.out.println(vehicle + "在公路上运行.....");
    }
}

class AirVehicle {
    public void run(String vehicle) {
        System.out.println(vehicle + "在公路上运行.....");
    }
}