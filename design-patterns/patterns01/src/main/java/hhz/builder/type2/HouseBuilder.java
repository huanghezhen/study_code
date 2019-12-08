package hhz.builder.type2;

public abstract class HouseBuilder {

    protected House house = new House();

    public abstract void basic();

    public abstract void walls();

    public abstract void roofed();

    public House buildHouse() {
        return house;
    }
}
