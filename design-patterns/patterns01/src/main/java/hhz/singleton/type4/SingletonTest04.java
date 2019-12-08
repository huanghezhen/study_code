package hhz.singleton.type4;

public class SingletonTest04 {
    public static void main(String[] args) throws Exception {

        // 线程安全

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

    public static synchronized Singleton getInstance(){
        if (instance == null) {
            instance = new Singleton();
        }

        return instance;
    }
}
