package hhz.builder.type2;

public class HighHouse extends HouseBuilder {
    @Override
    public void basic() {
        System.out.println("高楼 basic");
    }

    @Override
    public void walls() {
        System.out.println("高楼 walls");
    }

    @Override
    public void roofed() {
        System.out.println("高楼 roofed");
    }
}
