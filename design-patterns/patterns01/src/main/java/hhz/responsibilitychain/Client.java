package hhz.responsibilitychain;

/**
 * @ClassName: Client
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/11 16:02
 */
public class Client {
    public static void main(String[] args) throws Exception {
        Department department = new Department("Department");
        College college = new College("College");
        School school = new School("School");

        department.setApproval(college);
        college.setApproval(school);

        PurchaseRequest purchaseRequest = new PurchaseRequest(1, 5100f, 3);
        department.process(purchaseRequest);
    }
}
