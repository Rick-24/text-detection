package dlut.edu.text.web.utils;

import dlut.edu.text.web.security.GrantedAuthorityImpl;
import dlut.edu.text.web.security.JwtAuthenticationToken;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * JWT 工具类
 *
 * @Author : hongwei.zhw
 * @create 2022/1/2 16:16
 */
public class JwtTokenUtils implements Serializable {

    public static final long serialVersionUID = 1L;

    /**
     * 用户名称
     */
    public static final String USERNAME = Claims.SUBJECT;
    /**
     * 创建时间
     */
    public static final String CREATED = "created";
    /**
     * 权限列表
     */
    public static final String AUTHORITIES = "authorities";
    /**
     * 密钥
     */
    public static final String SECRET = "abcdefgh";
    /**
     * 有效期 12小时
     */
    public static final long EXPIRE_TIME = 12 * 60 * 60 * 1000;

    /**
     * 生成令牌
     *
     * @param authentication
     * @return 令牌
     */
    public static String generateToken(Authentication authentication) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(USERNAME, SecurityUtils.getUsername(authentication));
        claims.put(CREATED, new Date());
        claims.put(AUTHORITIES, authentication.getAuthorities());

        return generateToken(claims);
    }

    /**
     * 从数据声明生成令牌
     *
     * @param claims 数据生命
     * @return 令牌
     */
    public static String generateToken(Map<String, Object> claims) {
        Date expirationDate = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .compact();
    }


    public static Authentication getAuthenticationFromToken(HttpServletRequest request) {
        Authentication authentication = null;
        // 获取请求携带的令牌
        String token = JwtTokenUtils.getToken(request);
        if (token != null) {
            // 请求令牌不能为空
            if(SecurityUtils.getAuthentication() == null){
                // 上下文中Authentication 为空
                Claims claims = getClaimsFromToken(token);
                if(claims ==null){
                    return null;
                }
                String username = claims.getSubject();
                if(username == null) {
                    return null;
                }
                if(isTokenExpired(token)) {
                    return null;
                }
                Object authors = claims.get(AUTHORITIES);
                List<GrantedAuthority> authorities = new ArrayList<>();
                if (authors != null && authors instanceof List) {
                    for(Object object : (List) authors) {
                        authorities.add(new GrantedAuthorityImpl((String) ((Map) object).get("authority")));
                    }
                }

                authentication = new JwtAuthenticationToken(username,null,authorities,token);
            } else {
                if(validateToken(token,SecurityUtils.getUsername())){
                    // 如果上下文中Authentication非空，且请求令牌合法，直接返回当前登录认证信息
                    authentication = SecurityUtils.getAuthentication();
                }
            }
        }
        return authentication;
    }

    public static boolean validateToken(String token, String username) {
        String userName = getUsernameFromToken(token);
        return (userName.equals(username) && !isTokenExpired(token));
    }

    public static String getUsernameFromToken(String token) {
        String username;
        try {
            Claims claims = getClaimsFromToken(token);
            username = claims.getSubject();
        } catch (Exception e) {
            username = null;
        }
        return username;
    }

    /**
     * 判断令牌是否过期
     * @param token
     * @return
     */
    private static boolean isTokenExpired(String token) {
        try {
            Claims claims = getClaimsFromToken(token);
            Date expiration = claims.getExpiration();
            return expiration.before(new Date());
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 从令牌中获取数据
     * @param token
     * @return
     */
    private static Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }

    /**
     * 获取请求token
     *
     * @param request
     */
    public static String getToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        String tokenHead = "Bearer ";
        if (token == null) {
            token = request.getHeader("token");
        } else if (token.contains(tokenHead)) {
            token = token.substring(tokenHead.length());
        }

        if ("".equals(token)) {
            token = null;
        }
        return token;
    }
}
