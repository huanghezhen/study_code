package hhz.common.controller;


import hhz.common.model.domain.system.response.ProfileResult;
import io.jsonwebtoken.Claims;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseController {

    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected String companyId;
    protected String companyName;
    protected Claims claims;

    /*@ModelAttribute  jwt
    public void setResAnReq(HttpServletRequest request,HttpServletResponse response) {
        this.request = request;
        this.response = response;

        Object obj = request.getAttribute("user_claims");

        if(obj != null) {
            this.claims = (Claims) obj;
            this.companyId = (String)claims.get("companyId");
            this.companyName = (String)claims.get("companyName");
        }
    }*/

    @ModelAttribute
    public void setResAnReq(HttpServletRequest request,HttpServletResponse response) {
        this.request = request;
        this.response = response;
        Subject subject = SecurityUtils.getSubject();
        PrincipalCollection previousPrincipals = subject.getPreviousPrincipals();
        if (previousPrincipals != null) {
            ProfileResult profileResult = (ProfileResult) previousPrincipals.getPrimaryPrincipal();
            this.companyId = profileResult.getCompanyId();
            this.companyName = profileResult.getCompany();
        }
    }
}
