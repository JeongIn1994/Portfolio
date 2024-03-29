package com.practice.jeongin.portfolio.config.auth;

import com.practice.jeongin.portfolio.domain.user.Role;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .csrf().disable()
                    .headers().contentTypeOptions().disable()
                .and()
                .authorizeRequests()
                    .antMatchers("/style/**", "/script/**", "/image/**", "/fonts/**",
                            "/", "/board/**", "/view/**", "/upload.do", "/replies/**", "/display/**","/imageDisplay/**", "/history/list","/history/view/**","/summaryUploadAjax").permitAll()
                    .antMatchers("/board/register", "/board/modify").hasAnyRole(Role.USER.name(), Role.ADMIN.name())
                    .antMatchers("/setting", "/api/v1/posts","/history/register","/history/update/**","/info/update","/update/user","/utilsFileUploadAjax").hasAnyRole(Role.ADMIN.name())
                    .anyRequest().authenticated()
                .and()
                    .logout().logoutSuccessUrl("/")
                .and()
                    .oauth2Login()
                        .userInfoEndpoint()
                            .userService(customOAuth2UserService)
                .and()
                .defaultSuccessUrl("/",true);

    }
}
