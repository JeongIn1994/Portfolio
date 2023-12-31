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
                .headers().frameOptions().disable()
                .and()
                .authorizeRequests().antMatchers("/","/board/**","/view/**","/upload.do","/css/**","/images/**","/js/**","/replies/**","/display","/history/**")
                .permitAll().antMatchers("/api/v1/**","board/register","board/modify").hasAnyRole(Role.USER.name(),Role.ADMIN.name())
                .and().authorizeRequests().antMatchers("/setting","/posts/").hasAnyRole(Role.ADMIN.name())
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
