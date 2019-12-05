package hhz.principle.inversion;

/**
 * huanghz
 * 2019/12/3 下午2:53
 */
public class DependencyInversion1 {
    public static void main(String[] args) throws Exception {
        Person person = new Person();
        person.receive(new Email());
    }
}


class Email {
    public String getInfo() {
        return "电子邮件信息: hello";
    }
}


class Person {
    public void receive(Email email) {
        System.out.println(email.getInfo());
    }
}
