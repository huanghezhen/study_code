package hhz.company.service;

import hhz.common.model.domain.company.Company;

/**
 * @ClassName: CompanyService
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/18 14:41
 */
public interface CompanyService {

    void save(Company company);

    void update(Company company);

    void delete(String id);

    Company getCompanyById();


}
