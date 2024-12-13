package dev.cbq.config;

import dev.cbq.security.handler.SecurityAccessDeniedHandler;
import dev.cbq.security.handler.SecurityAuthenticationEntryPoint;
import dev.cbq.security.handler.SecurityLogoutSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(authorizer -> authorizer
                        .requestMatchers(
                                "/api/v1/users/login",
                                "/api/v1/users/register",
                                "/api/v1/tests/*/**"
                        )
                        .permitAll()
                        .anyRequest()
                        .authenticated()
                )
                .httpBasic(AbstractHttpConfigurer::disable)
                .csrf(AbstractHttpConfigurer::disable)
                .formLogin(AbstractHttpConfigurer::disable)
                .logout(logout -> logout
                        .logoutUrl("/api/v1/user/logout")
                        .invalidateHttpSession(true)
                        .logoutSuccessHandler(new SecurityLogoutSuccessHandler())
                )
                .exceptionHandling(ex -> ex
                        .accessDeniedHandler(new SecurityAccessDeniedHandler())
                        .authenticationEntryPoint(new SecurityAuthenticationEntryPoint())
                ).build();
    }

}
