package dev.cbq.security.adapter;

import dev.cbq.user.model.User;
import dev.cbq.user.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public record SecurityUserDetailsService(UserService userService) implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userService.loadUserDetails(username)
                .orElseThrow(() -> new UsernameNotFoundException("用户名 " + username + " 不存在"));

        return new SecurityUserDetails(user);
    }
}
