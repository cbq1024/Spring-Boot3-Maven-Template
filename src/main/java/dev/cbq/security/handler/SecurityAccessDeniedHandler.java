package dev.cbq.security.handler;

import dev.cbq.base.RestBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import java.io.IOException;

@Slf4j
public class SecurityAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request,
                       HttpServletResponse response,
                       AccessDeniedException accessDeniedException) throws IOException, ServletException {

        if (log.isInfoEnabled()) {
            log.info("未授权: {}", accessDeniedException.getMessage());
        }
        RestBean.forbidden("你没有相关资源的访问权限、请系统系统管理员");

    }
}
