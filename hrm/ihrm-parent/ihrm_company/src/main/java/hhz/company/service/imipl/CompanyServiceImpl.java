package hhz.company.service.imipl;

import hhz.common.model.domain.company.Company;
import hhz.common.utils.IdWorker;
import hhz.company.dao.CompanyDao;
import hhz.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: CompanyServiceImpl
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/18 14:41
 */
@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private IdWorker idWorker;

    @Override
    public void save(Company company) {
        String id = String.valueOf(idWorker.nextId());
        company.setId(id);
        companyDao.save(company);
    }

    @Override
    public void update(Company company) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public Company getCompanyById() {

        return null;
    }
}
