package hhz.state;

/**
 * @ClassName: State
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/11 14:39
 */
public abstract class State {
    public abstract void deductMoney();

    public abstract boolean raffle();

    public abstract void dispensePrize();
}
