package hhz.proxy.demo1;

/**
 * @ClassName: TeacherDaoProxy
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/10 15:30
 */
public class TeacherDaoProxy implements ITeacherDao {

    private ITeacherDao iTeacherDao;

    public TeacherDaoProxy(ITeacherDao iTeacherDao) {
        this.iTeacherDao = iTeacherDao;
    }

    @Override
    public void teach() {
        System.out.println("TeacherDaoProxy");
    }
}
