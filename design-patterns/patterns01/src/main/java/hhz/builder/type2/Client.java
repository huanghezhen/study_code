package hhz.builder.type2;

public class Client {
    public static void main(String[] args) throws Exception {
        CommonHouse commonHouse = new CommonHouse();

        HouseDirector houseDirector = new HouseDirector(commonHouse);
        House house = houseDirector.build1();

        StringBuffer stringBuffer = new StringBuffer();
    }
}
