package com.sangsoo.book.springboot.config.auth;

import com.sangsoo.book.springboot.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Spring Security config
 *
 * @EnableWebSecurity -> Spring Security 설정 활성화
 * */
@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable().headers().frameOptions().disable()    // h2-console 화면을 사용하기 위해 해당 옵션들을 disabled()
                .and()
                .authorizeRequests()                                    // URL별 권한 관리 설정 옵션 시작
                .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**", "/profile").permitAll()
                .antMatchers("/api/v1/**").hasRole(Role.USER.name())
                .anyRequest().authenticated()
                .and()
                .logout().logoutSuccessUrl("/")                         // 로그아웃 성공 시 /로 이동
                .and()
                .oauth2Login()
                .userInfoEndpoint()
                .userService(customOAuth2UserService);                  // 로그인 성공 시 후속 조치를 진행할 UserService 인터페이스의 구현체를 등록.
    }
}