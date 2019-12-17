package com.test;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @ClassName: EncodingTest
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/16 20:55
 */
public class EncodingTest {
    public static void main(String[] args) throws Exception {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        System.out.println(bCryptPasswordEncoder.encode("1"));
    }
}
