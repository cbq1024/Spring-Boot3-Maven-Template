package dev.cbq.security.adapter;

import dev.cbq.base.AuthConst;
import org.springframework.security.core.GrantedAuthority;

import java.util.Objects;

public record SecurityGrantedAuthority(String authority) implements GrantedAuthority {


    @Override
    public String getAuthority() {
        return authority;
    }

    public static SecurityGrantedAuthority role(String authority) {
        Objects.requireNonNull(authority);
        return new SecurityGrantedAuthority(AuthConst.ROLE_NAME_PREFIX + authority);
    }

    public static SecurityGrantedAuthority permission(String authority) {
        Objects.requireNonNull(authority);
        return new SecurityGrantedAuthority(AuthConst.PERMISSION_NAME_PREFIX + authority);
    }
}
