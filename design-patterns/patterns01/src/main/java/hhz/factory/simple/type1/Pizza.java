package hhz.factory.simple.type1;

public abstract class Pizza {

    protected String name;

    public void prepare(){
        System.out.println(name+" preparing");
    }

    public void bake() {
        System.out.println(name+" baking");
    }

    public void cut() {
        System.out.println(name+" cutting");
    }

    public void box() {
        System.out.println(name+" boxing");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
