package hhz.responsibilitychain;

/**
 * @ClassName: School
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/11 16:01
 */
public class School  extends Approval {
    public School(String name) {
        super(name);
    }

    @Override
    public void process(PurchaseRequest request) {
        System.out.println(request.getId()+"被"+getName()+"处理");
    }
}
