package hhz.principle.liskov;

/**
 * huanghz
 * 2019/12/3 下午3:22
 */
public class Liskov1 {
    public static void main(String[] args) throws Exception {
        A1 a1 = new A1();
        System.out.println("11-3=" + a1.func1(11, 3));
        System.out.println("1-8=" + a1.func1(1, 8));

        System.out.println("-----------------------------------");

        B1 b1 = new B1();
        // 看方法说明
        System.out.println("11-3=" + b1.func1(11, 3));
        System.out.println("1-8=" + b1.func1(1, 8));
        System.out.println("11+3+9=" + b1.func2(11, 3));
    }
}


class A1 {
    public int func1(int num1, int num2) {
        return num1 - num2;
    }
}


class B1 extends A1 {
    /**
     * 这里重写了  不建议这样!!!!!
     * @param num1
     * @param num2
     * @return
     */
    @Override
    public int func1(int num1, int num2) {
        return num1 + num2;
    }

    public int func2(int num1, int num2) {
        return func1(num1, num2) + 9;
    }
}