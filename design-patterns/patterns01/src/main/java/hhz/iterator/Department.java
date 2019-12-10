package hhz.iterator;

/**
 * @ClassName: Department
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/10 17:56
 */
public class Department {
    private String name;
    private String des;

    public Department(String name, String des) {
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
