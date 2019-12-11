package hhz.state;

/**
 * @ClassName: dispenseOutState
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/11 14:38
 */
public class DispenseOutState extends State {
    private RaffleActivity activity;

    public DispenseOutState(RaffleActivity activity) {
        this.activity = activity;
    }

    @Override
    public void deductMoney() {
        System.out.println("不能扣积分");
    }

    @Override
    public boolean raffle() {
        System.out.println("不能抽奖");
        return false;
    }

    @Override
    public void dispensePrize() {
        System.out.println("不能发放奖品");
    }
}
