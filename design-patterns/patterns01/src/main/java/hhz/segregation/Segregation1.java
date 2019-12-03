package hhz.segregation;

/**
 * huanghz
 * 2019/12/3 下午2:00
 */
public class Segregation1 {
    public static void main(String[] args) throws Exception {
        B b = new B();
        D d = new D();
        A a = new A();
        C c = new C();

        a.depend1(b);
        a.depend2(b);
        a.depend3(b);


        c.depend1(d);
        c.depend4(d);
        c.depend5(d);
    }
}


interface Interface1 {
    void operation1();
    void operation2();
    void operation3();
    void operation4();
    void operation5();
}


class B implements Interface1 {

    @Override
    public void operation1() {
        System.out.println("B operation1");
    }

    @Override
    public void operation2() {
        System.out.println("B operation2");
    }

    @Override
    public void operation3() {
        System.out.println("B operation3");
    }

    @Override
    public void operation4() {
        System.out.println("B operation4");
    }

    @Override
    public void operation5() {
        System.out.println("B operation5");
    }
}


class D implements Interface1 {

    @Override
    public void operation1() {
        System.out.println("D operation1");
    }

    @Override
    public void operation2() {
        System.out.println("D operation2");
    }

    @Override
    public void operation3() {
        System.out.println("D operation3");
    }

    @Override
    public void operation4() {
        System.out.println("D operation4");
    }

    @Override
    public void operation5() {
        System.out.println("D operation5");
    }
}

class A {
    public void depend1(Interface1 interface1) {
        interface1.operation1();
    }

    public void depend2(Interface1 interface1) {
        interface1.operation2();
    }

    public void depend3(Interface1 interface1) {
        interface1.operation3();
    }
}


class C {
    public void depend1(Interface1 interface1) {
        interface1.operation1();
    }

    public void depend4(Interface1 interface1) {
        interface1.operation4();
    }

    public void depend5(Interface1 interface1) {
        interface1.operation5();
    }
}