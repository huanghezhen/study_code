package hhz.state;

/**
 * @ClassName: DispenseState
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/11 14:38
 */
public class DispenseState extends State {
    private RaffleActivity activity;

    public DispenseState(RaffleActivity activity) {
        this.activity = activity;
    }

    @Override
    public void deductMoney() {
        System.out.println("不能扣除积分");
    }

    @Override
    public boolean raffle() {
        System.out.println("不能抽奖");
        return false;
    }

    @Override
    public void dispensePrize() {
        if (activity.getCount() > 0) {
            System.out.println("恭喜中奖了");
            activity.setState(activity.getNo());
        } else {
            System.out.println("奖品领完了");
            activity.setState(activity.getDisOut());
        }
    }
}
