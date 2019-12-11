package hhz.responsibilitychain;

/**
 * @ClassName: PurchaseRequest
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/11 15:53
 */
public class PurchaseRequest {
    private int type;
    private float price;
    private int id;

    public PurchaseRequest(int type, float price, int id) {
        this.type = type;
        this.price = price;
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public float getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }
}
