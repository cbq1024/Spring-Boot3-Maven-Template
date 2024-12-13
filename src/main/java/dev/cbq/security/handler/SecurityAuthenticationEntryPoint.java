package dev.cbq.security.handler;

import dev.cbq.base.RestBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.AuthenticationEntryPoint;

import java.io.IOException;

public class SecurityAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {

        if (authException instanceof UsernameNotFoundException e) {
            RestBean.failure(HttpStatus.NOT_FOUND.value(), "用户名不存在");
            return;
        }

        // 访问没有的端点 | 未登录访问受限资源
        RestBean.failure(HttpStatus.NOT_FOUND.value(), "资源不存在");
    }
}
