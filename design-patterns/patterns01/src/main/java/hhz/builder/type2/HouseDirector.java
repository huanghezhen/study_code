package hhz.builder.type2;

public class HouseDirector {
    HouseBuilder houseBuilder;

    public HouseDirector(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    public House build1() {
        houseBuilder.basic();
        houseBuilder.walls();
        houseBuilder.roofed();

        return houseBuilder.buildHouse();
    }
}
