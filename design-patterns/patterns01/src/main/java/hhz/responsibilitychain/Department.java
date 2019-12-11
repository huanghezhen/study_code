package hhz.responsibilitychain;

/**
 * @ClassName: Department
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/11 15:57
 */
public class Department extends Approval {
    public Department(String name) {
        super(name);
    }

    @Override
    public void process(PurchaseRequest request) {
        if (request.getPrice() <= 5000) {
            System.out.println(request.getId()+"被"+getName()+"处理");
        }else {
            getApproval().process(request);
        }
    }
}
