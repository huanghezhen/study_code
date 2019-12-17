package com.itheima.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Secured({"ROLE_PRODUCT","ROLE_ADMIN"})
    @RequestMapping("/findAll")
    public String findAll(){
        return "product-list";
    }
}
