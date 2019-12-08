package hhz.singleton.type2;

public class SingletonTest01 {
    public static void main(String[] args) throws Exception {
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance1 == instance2);

        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());
    }
}


class Singleton {
    private static Singleton instance;

    private Singleton() {

    }

    static {
        instance = new Singleton();
    }

    public static Singleton getInstance() {
        return instance;
    }
}