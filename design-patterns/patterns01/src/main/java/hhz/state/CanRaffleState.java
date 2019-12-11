package hhz.state;

import java.util.Random;

/**
 * @ClassName: CanRaffleState
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/11 14:37
 */
public class CanRaffleState extends State {

    private RaffleActivity activity;

    public CanRaffleState(RaffleActivity activity) {
        this.activity = activity;
    }

    @Override
    public void deductMoney() {
        System.out.println("已经扣过了积分");
    }

    @Override
    public boolean raffle() {
        System.out.println("正在抽奖 请等待");
        Random r = new Random();
        int num = r.nextInt(10);
        if (num == 0) {
            activity.setState(activity.getDis());
            return true;
        }else {
            System.out.println("没有中奖");
            activity.setState(activity.getNo());
            return false;
        }
    }

    @Override
    public void dispensePrize() {
        System.out.println("不能发放奖品");
    }
}
