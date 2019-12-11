package hhz.responsibilitychain;

/**
 * @ClassName: College
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/11 16:00
 */
public class College  extends Approval {
    public College(String name) {
        super(name);
    }

    @Override
    public void process(PurchaseRequest request) {
        if (request.getPrice() > 5000 && request.getPrice() <= 10000) {
            System.out.println(request.getId()+"被"+getName()+"处理");
        }else {
            getApproval().process(request);
        }
    }
}
