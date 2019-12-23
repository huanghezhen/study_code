package hhz.member.dao;

import hhz.common.entity.member.User;

/**
 * @ClassName: MemberMapper
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/23 10:12
 */
public interface MemberMapper {
    User getUserByUsername(String username);
}
