package hhz.company;

import hhz.company.dao.CompanyDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @ClassName: CompanyApplicationTest
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/18 14:36
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class CompanyApplicationTest {
    @Autowired
    private CompanyDao companyDao;

    @Test
    public void companyDaoTest() {
        Company company = companyDao.findById("1").get();
        System.out.println(company);
    }
}
