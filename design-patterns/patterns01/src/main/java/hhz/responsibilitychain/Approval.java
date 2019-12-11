package hhz.responsibilitychain;

/**
 * @ClassName: Approver
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/11 15:55
 */
public abstract class Approval {
    private Approval approval;
    private String name;

    public Approval(String name) {
        this.name = name;
    }

    public void setApproval(Approval approval) {
        this.approval = approval;
    }

    public Approval getApproval() {
        return approval;
    }

    public String getName() {
        return name;
    }

    public abstract void process(PurchaseRequest request);
}
