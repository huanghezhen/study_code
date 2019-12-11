package hhz.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Caretaker
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/11 14:00
 */
public class Caretaker {
    private List<Memento> mementoList = new ArrayList<>();

    public void add(Memento memento) {
        mementoList.add(memento);
    }

    public Memento get(int index) {
        return mementoList.get(index);
    }


}
