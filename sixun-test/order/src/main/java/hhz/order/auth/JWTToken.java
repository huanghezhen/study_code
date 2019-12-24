package hhz.order.auth;

import org.apache.shiro.authc.AuthenticationToken;

public class JWTToken implements AuthenticationToken {
  private static final long serialVersionUID = -6496128678249182260L;
  private String token;

  public JWTToken(String token) {
    this.token = token;
  }
  @Override
  public Object getPrincipal() {
    return token;
  }

  @Override
  public Object getCredentials() {
    return token;
  }
}
