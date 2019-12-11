package hhz.mediator;

/**
 * @ClassName: Alarm
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/11 11:44
 */
public class Alarm extends Colleague {
    public Alarm(Mediator mediator, String name) {
        super(mediator, name);
        mediator.register(name, this);
    }

    public void sendAlarm(int stateChange) {
        sendMessage(stateChange);
    }


    @Override
    public void sendMessage(int stateChange) {
        getMediator().getMessage(stateChange, name);
    }
}
