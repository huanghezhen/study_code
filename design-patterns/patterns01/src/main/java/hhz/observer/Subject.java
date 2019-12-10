package hhz.observer;



/**
 * @ClassName: Subject
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/10 21:34
 */
public interface Subject {

    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();

}
