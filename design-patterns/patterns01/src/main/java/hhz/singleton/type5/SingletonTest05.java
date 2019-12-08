package hhz.singleton.type5;

public class SingletonTest05 {
    public static void main(String[] args) throws Exception {

        // 线程安全  双重检查

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

    public static Singleton getInstance(){
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
