package dlut.edu.text.web.security;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by IntelliJ IDEA.
 * 权限封装
 *
 * @Author : hongwei.zhw
 * @create 2022/1/2 15:47
 */
public class GrantedAuthorityImpl implements GrantedAuthority {
    private static final long serialVersionUID = 1L;

    private String authority;

    public GrantedAuthorityImpl(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
