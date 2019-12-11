package hhz.state;

/**
 * @ClassName: Client
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/11 14:38
 */
public class Client {
    public static void main(String[] args) throws Exception {
        RaffleActivity activity = new RaffleActivity(1);

        for (int i = 0; i < 10; i++) {
            System.out.println("第" + i + "次抽奖");
            activity.deductMoney();
            activity.raffle();
        }
    }
}
