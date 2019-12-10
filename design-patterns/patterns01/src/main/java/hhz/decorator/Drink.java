package hhz.decorator;

/**
 * @ClassName: Drink
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/10 8:09
 */

public abstract class Drink {
    public String des;
    private float price = 0.0f;

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public abstract float cost();
}
