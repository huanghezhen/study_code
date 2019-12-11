package hhz.memento;

/**
 * @ClassName: Memento
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/11 13:58
 */
public class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
