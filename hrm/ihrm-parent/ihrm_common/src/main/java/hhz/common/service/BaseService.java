package hhz.common.service;


import org.springframework.data.jpa.domain.Specification;

public class BaseService<T> {

    protected Specification<T> getSpec(String companyId) {
        Specification<T> spect = (Specification) (root, criteriaQuery, cb) -> {
            //根据企业id查询
            return cb.equal(root.get("companyId").as(String.class),companyId);
        };
        return spect;
    }
}
