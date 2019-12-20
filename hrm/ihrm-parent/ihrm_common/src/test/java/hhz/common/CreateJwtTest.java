package hhz.common;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.Test;

import java.util.Date;

/**
 * @ClassName: CreateJwtTest
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/20 11:30
 */
public class CreateJwtTest {

    @Test
    public void getToken() {
        JwtBuilder jwtBuilder = Jwts.builder()
                .setId("33")
                .setSubject("小白")
                .setIssuedAt(new Date())
                .claim("fMer","KZ")
                .signWith(SignatureAlgorithm.HS256, "ihrm");
        String token = jwtBuilder.compact();
        System.out.println(token);
    }

    @Test
    public void parseToken() {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIzMyIsInN1YiI6IuWwj-eZvSIsImlhdCI6MTU3NjgxMzQ2OSwiZk1lciI6IktaIn0.cWzVZZ_kmArwegwwqHerocBu2OQc-dUa-nSftZrGGTw";
        Claims claims = Jwts.parser().setSigningKey("ihrm").parseClaimsJws(token).getBody();
        System.out.println(claims.getId());
        System.out.println(claims.getSubject());
        System.out.println(claims.getIssuedAt());

        Object fMer = claims.get("fMer");
        System.out.println(fMer);
    }
}
