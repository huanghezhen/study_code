package hhz.principle.segregation;

/**
 * huanghz
 * 2019/12/3 下午2:13
 */
public class Segregation2 {
    public static void main(String[] args) throws Exception {

    }
}


interface Interface2 {
    void operation1();
}

interface Interface3 {
    void operation2();
    void operation3();
}

interface Interface4 {
    void operation4();
    void operation5();
}

class B1 implements Interface2, Interface3 {

    @Override
    public void operation1() {

    }

    @Override
    public void operation2() {

    }

    @Override
    public void operation3() {

    }
}

class D1 implements Interface2, Interface4 {

    @Override
    public void operation1() {

    }

    @Override
    public void operation4() {

    }

    @Override
    public void operation5() {

    }
}