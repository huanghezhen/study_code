package hhz.state;

/**
 * @ClassName: RaffleActivity
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/11 14:42
 */
public class RaffleActivity {
    private State state;
    private int count;
    private State no = new NoRaffleState(this);
    private State can = new CanRaffleState(this);
    private State dis = new DispenseState(this);
    private State disOut = new DispenseOutState(this);

    public RaffleActivity(int count) {
        this.state = getNo();
        this.count = count;
    }

    public void deductMoney() {
        state.deductMoney();
    }

    public void raffle() {
        if (state.raffle()) {
            state.dispensePrize();
        }
    }



    public int getCount() {
        int curCount = count;
        count--;
        return curCount;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getNo() {
        return no;
    }

    public void setNo(State no) {
        this.no = no;
    }

    public State getCan() {
        return can;
    }

    public void setCan(State can) {
        this.can = can;
    }

    public State getDis() {
        return dis;
    }

    public void setDis(State dis) {
        this.dis = dis;
    }

    public State getDisOut() {
        return disOut;
    }

    public void setDisOut(State disOut) {
        this.disOut = disOut;
    }
}
