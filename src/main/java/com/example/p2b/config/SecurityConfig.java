package com.example.p2b.config;

import com.example.p2b.domain.Role;
import com.example.p2b.handler.AuthSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private com.example.p2b.service.CustomizeUserDetailsService customizeUserDetailsService;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customizeUserDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/users/signup", "/users/emailCheck", "/users/idCheck", "/users/list", "/login/search/id",
                        "/login/search/password","/users/findIdResult","/users/changePassword").permitAll()
                .antMatchers("/users/").hasAuthority(Role.USER.getValue())
                .antMatchers("/guest/").hasAuthority(Role.ANONYMOUS.getValue())
                .and()
                .formLogin()
                .loginPage("/login/login")
                .permitAll()
                .successHandler(new AuthSuccessHandler()) // 성공 핸들러 사용 설정
                .failureUrl("/login/login?error") // 로그인 실패 시
                .and()
                .logout()
                .logoutUrl("/users/logout")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .logoutSuccessUrl("/")
                .and()
                .anonymous().authorities(Role.ANONYMOUS.getValue()); // 로그인하지 않은 사용자는 ANONYMOUS 공인
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
