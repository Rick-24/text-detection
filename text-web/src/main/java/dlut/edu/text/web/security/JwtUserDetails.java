package dlut.edu.text.web.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * Created by IntelliJ IDEA.
 * 安全用户模型
 * @Author : hongwei.zhw
 * @create 2022/1/2 15:26
 */
public class JwtUserDetails implements UserDetails {
    private static final long serialVersionUID = 1L;
    private String username;
    private String password;
    private String salt;
    private Collection<? extends GrantedAuthority> authorities;

    public JwtUserDetails(String username, String password, String salt, Collection<? extends GrantedAuthority> authorities) {
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.authorities = authorities;
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }
    public String getSalt() {
        return salt;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
