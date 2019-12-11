package hhz.mediator;

/**
 * @ClassName: Colleague
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/11 11:44
 */
public abstract class Colleague {
    private Mediator mediator;
    public String name;

    public Colleague(Mediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    public Mediator getMediator() {
        return mediator;
    }

    public abstract void sendMessage(int stateChange);
}
