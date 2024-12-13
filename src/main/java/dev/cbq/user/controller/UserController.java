package dev.cbq.user.controller;

import dev.cbq.base.RestBean;
import dev.cbq.security.adapter.SecurityUserDetails;
import dev.cbq.security.help.PasswordEncoderHelper;
import dev.cbq.user.model.Role;
import dev.cbq.user.model.User;
import dev.cbq.user.service.UserService;
import dev.cbq.user.vo.UserStruct;
import dev.cbq.user.vo.request.UserLoginVo;
import dev.cbq.user.vo.request.UserRegisterVo;
import dev.cbq.user.vo.response.UserInfoVo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService service;
    private final UserDetailsService userDetailsService;

    public UserController(UserService service, UserDetailsService userDetailsService) {
        this.service = service;
        this.userDetailsService = userDetailsService;
    }

    @PostMapping("/login")
    public RestBean<UserInfoVo> login(@RequestBody UserLoginVo vo, HttpServletRequest request) {

        // userBody.getCode() do check your verify code ...

        String username = vo.getUsername();
        String password = vo.getPassword();

        SecurityUserDetails userDetails = (SecurityUserDetails) userDetailsService.loadUserByUsername(username);

        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        if (passwordEncoder.matches(password, userDetails.getPassword())) {
            UsernamePasswordAuthenticationToken token =
                    new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(), userDetails.getAuthorities());

            SecurityContext context = SecurityContextHolder.getContext();

            context.setAuthentication(token);

            HttpSession session = request.getSession(true);

            session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, context);

            User user = userDetails.user();
            UserInfoVo userInfoVo = UserStruct.INSTANCE.toInfoVo(user);

            return RestBean.success(userInfoVo);

        }
        return RestBean.unauthorized("用户名或密码错误");

    }

    @PostMapping("/register")
    public void register(@RequestBody UserRegisterVo vo) {

        User user = new User();
        user.setUsername(vo.getUsername());
        user.setEmail(vo.getEmail());
        user.setPassword(PasswordEncoderHelper.encryptPassword(vo.getPassword()));

        service.save(user);

    }

    @GetMapping("/details")
    public RestBean<Map<String, Object>> getUserDetails(Authentication authentication) {
        SecurityUserDetails userDetails = (SecurityUserDetails) authentication.getPrincipal();

        HashMap<String, Object> map = new HashMap<>();
        map.put("username", userDetails.getUsername());
        List<? extends GrantedAuthority> authorities = userDetails.getAuthorities().stream().toList();
        map.put("authorities", authorities);
        return RestBean.success(map);
    }

    @GetMapping("/welcome")
    public RestBean<String> welcome() {
        return RestBean.success("Hello World");
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/admin")
    public RestBean<String> admin() {
        return RestBean.success("ADMIN OPTION ...");
    }


}
