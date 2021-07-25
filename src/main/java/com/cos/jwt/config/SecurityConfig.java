package com.cos.jwt.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import lombok.Builder.ObtainVia;

public class SecurityConfig extends WebSecurityConfigurerAdapter{
    
    @Override
    protected void configure(HttpSecurity http)throws Exception{
        http.csrf().disable();
        //세션을 사용하지 않겠다는말
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
        .formLogin().disable()//기본적인 http로그인 안쓰겟다
        .httpBasic().disable()
        .authorizeRequests()
        .antMatchers("/api/vi/user/**")
        .access("hasRol('ROLE_USER')or hasRole('ROLE_ADMIN') or hasRole('ROLE_MANAGER')")
        .antMatchers("/api/vi/manager/**")
        .access("hasRole('ROLE_ADMIN') or hasRole('ROLE_MANAGER')")
        .antMatchers("/api/vi/admin/**")
        .access("hasRole('ROLE_ADMIN')")
        .anyRequest().permitAll();//다른요청은 전부 권한없이 들어감
    }
}
