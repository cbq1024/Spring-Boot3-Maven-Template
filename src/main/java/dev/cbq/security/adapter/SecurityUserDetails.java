package dev.cbq.security.adapter;

import dev.cbq.user.model.Permission;
import dev.cbq.user.model.Role;
import dev.cbq.user.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public record SecurityUserDetails(User user) implements UserDetails {

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        List<GrantedAuthority> authorities = new ArrayList<>();

        Role role = user.getRole();

        if (role == null) {
            return authorities;
        }

        authorities.add(SecurityGrantedAuthority.role(role.getRoleName()));

        List<Permission> permissionList = role.getPermissions();
        for (Permission permission : permissionList) {
            authorities.add(SecurityGrantedAuthority.permission(permission.getPermissionName()));
        }

        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isEnabled() {
        return user.getDeleted() == 0 ? Boolean.TRUE : Boolean.FALSE;
    }
}
