package hhz.state;

/**
 * @ClassName: NoRaffleState
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/11 14:39
 */
public class NoRaffleState extends State {
    private RaffleActivity activity;

    public NoRaffleState(RaffleActivity activity) {
        this.activity = activity;
    }


    @Override
    public void deductMoney() {
        System.out.println("扣除50积分成功,您可以抽奖了");
        activity.setState(activity.getCan());
    }

    @Override
    public boolean raffle() {
        System.out.println("扣了积分才能抽奖");
        return false;
    }

    @Override
    public void dispensePrize() {
        System.out.println("不能发放奖品");
    }
}
