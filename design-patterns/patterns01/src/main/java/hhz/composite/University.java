package hhz.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: University
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/10 8:55
 */
public class University extends OrganizationComponent {

    private List<OrganizationComponent> organizationComponentList = new ArrayList<>();

    public University(String name, String des) {
        super(name, des);
    }

    @Override
    protected void add(OrganizationComponent organizationComponent) {
        organizationComponentList.add(organizationComponent);
    }

    @Override
    protected void remove(OrganizationComponent organizationComponent) {
        organizationComponentList.remove(organizationComponent);
    }


    @Override
    protected void print() {
        System.out.println("-------------" + getName() + "------------");
        for (OrganizationComponent organizationComponent : organizationComponentList) {
            organizationComponent.print();
        }
    }
}
