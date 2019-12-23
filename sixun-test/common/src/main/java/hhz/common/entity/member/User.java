package hhz.common.entity.member;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName: User
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/23 13:43
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 5242780331636944113L;
    private String fId;
    private String fUsername;
    private String fPassword;
    private Integer fType;
    private String fMer;
}
