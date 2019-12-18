package hhz.company;

import hhz.common.utils.IdWorker;
import org.junit.Test;

/**
 * @ClassName: OtherTest
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/18 14:48
 */
public class OtherTest {
    @Test
    public void getId() {
        IdWorker idWorker = new IdWorker();
        long l = System.currentTimeMillis();
        for (int i = 0; i < 1000*1000; i++) {
            idWorker.nextId();
        }
        System.out.println(System.currentTimeMillis()-l);
    }
}
