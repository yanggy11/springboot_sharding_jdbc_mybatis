package com.yanggy.springboot.jwt;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * Created by yangguiyun on 2017/9/26.
 */
public final class JWTUser implements UserDetails {
    private long userId;
    private  String username;
    private  String password;
    private  String phone;
    private  Collection<? extends GrantedAuthority> authorities;

    public JWTUser(long id, String username, String password, String phone, Collection<? extends GrantedAuthority> authorities) {
        this.userId = id;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.authorities = authorities;
    }

    @Override
    public String getUsername() {
        return username;
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

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public long getUserId() {
        return userId;
    }

    public String getPhone() {
        return phone;
    }
}
