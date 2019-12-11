package hhz.mediator;

/**
 * @ClassName: Mediator
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/11 11:45
 */
public abstract class Mediator {
    public abstract void register(String colleagueName, Colleague colleague);

    public abstract void getMessage(int stateChange, String colleagueName);

    public abstract void sendMessage();
}
