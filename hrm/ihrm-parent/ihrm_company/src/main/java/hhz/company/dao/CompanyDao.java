package hhz.company.dao;

import hhz.common.model.domain.company.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @ClassName: CompanyDao
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/18 14:34
 */
public interface CompanyDao extends JpaRepository<Company,String>, JpaSpecificationExecutor<Company> {
}
