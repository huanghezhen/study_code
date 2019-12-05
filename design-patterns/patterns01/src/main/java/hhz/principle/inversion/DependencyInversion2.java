package hhz.principle.inversion;

/**
 * huanghz
 * 2019/12/3 下午3:03
 */
public class DependencyInversion2 {
    public static void main(String[] args) throws Exception {
        Person2 person2 = new Person2();

        person2.receive(new WeChat2());
        person2.receive(new Email2());
    }
}

interface IReceiver2{
    String getInfo();
}



class Email2 implements IReceiver2{

    @Override
    public String getInfo() {
        return "电子邮件信息: hello";
    }
}

class WeChat2 implements IReceiver2{

    @Override
    public String getInfo() {
        return "微信信息: hello";
    }
}


class Person2 {
    public void receive(IReceiver2 iReceiver2) {
        System.out.println(iReceiver2.getInfo());
    }
}