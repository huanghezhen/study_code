package hhz.memento;

/**
 * @ClassName: Originator
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/11 13:55
 */
public class Originator {
    private String state;


    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Memento saveStateMemento() {
        return new Memento(state);
    }

    public void getStateFromMemento(Memento memento) {
        state = memento.getState();
    }
}
