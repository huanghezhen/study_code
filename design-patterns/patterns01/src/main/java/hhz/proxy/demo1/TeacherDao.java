package hhz.proxy.demo1;

/**
 * @ClassName: TeacherDao
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/10 15:29
 */
public class TeacherDao implements ITeacherDao {
    @Override
    public void teach() {
        System.out.println("TeacherDao");
    }
}
