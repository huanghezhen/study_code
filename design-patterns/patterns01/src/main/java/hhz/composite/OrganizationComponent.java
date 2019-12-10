package hhz.composite;

/**
 * @ClassName: OrganizationComponent
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/10 8:54
 */
public abstract class OrganizationComponent {
    private String name;

    private String des;

    protected void add(OrganizationComponent organizationComponent) {
        throw new UnsupportedOperationException();
    }

    protected void remove(OrganizationComponent organizationComponent) {
        throw new UnsupportedOperationException();
    }

    protected abstract void print();


    public OrganizationComponent(String name, String des) {
        this.name = name;
        this.des = des;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
