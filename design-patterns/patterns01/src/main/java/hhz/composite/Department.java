package hhz.composite;

/**
 * @ClassName: Department
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/10 8:54
 */
public class Department extends OrganizationComponent {

    public Department(String name, String des) {
        super(name, des);
    }

    @Override
    protected void print() {
        System.out.println(getName());
    }
}
