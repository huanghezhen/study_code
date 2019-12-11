package hhz.memento;

/**
 * @ClassName: Client
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/11 14:01
 */
public class Client {
    public static void main(String[] args) throws Exception {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();

        originator.setState("1");
        caretaker.add(originator.saveStateMemento());

        originator.setState("3");
        caretaker.add(originator.saveStateMemento());

        originator.setState("2");
        caretaker.add(originator.saveStateMemento());

        System.out.println("当前的状态是 " + originator.getState());
        originator.getStateFromMemento(caretaker.get(1));
        System.out.println("当前的状态是 " + originator.getState());


    }
}
