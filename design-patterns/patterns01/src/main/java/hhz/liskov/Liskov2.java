package hhz.liskov;

/**
 * huanghz
 * 2019/12/3 下午3:29
 */
public class Liskov2 {
    public static void main(String[] args) throws Exception {
        A2 a2 = new A2();
        System.out.println("11-3=" + a2.func1(11, 3));
        System.out.println("1-8=" + a2.func1(1, 8));

        System.out.println("-----------------------------------");

        B2 b2 = new B2();
        // 看方法说明
        System.out.println("11-3+9=" + b2.func3(11, 3));
        System.out.println("1-8+9=" + b2.func3(1, 8));
        System.out.println("1+8=" + b2.func1(1, 8));
        System.out.println("11+3+9=" + b2.func2(11, 3));
    }
}

class Base2{

}

class A2 extends Base2 {
    public int func1(int num1, int num2) {
        return num1 - num2;
    }
}


class B2 extends Base2 {

    private A2 a2 = new A2();

    public int func1(int num1, int num2) {
        return num1 + num2;
    }

    public int func2(int num1, int num2) {
        return func1(num1, num2) + 9;
    }

    public int func3(int num1, int num2) {
        return a2.func1(num1, num2) + 9;
    }
}