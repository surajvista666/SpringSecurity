package com.spring.Security.springSecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails adminUser = User
                .withUsername("ankit")
                .password("1234")
                .roles("ADMIN")
                .build();
        UserDetails managerUser = User
                .withUsername("suraj")
                .password("123")
                .roles("MANAGER")
                .build();
        UserDetails employeeUser = User
                .withUsername("amit")
                .password("12345")
                .roles("EMPLOYEE")
                .build();

        return new InMemoryUserDetailsManager(adminUser,managerUser,employeeUser);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.csrf().disable()
                .authorizeHttpRequests()
                .antMatchers("/login/admin")
                .hasRole("ADMIN")
                .antMatchers("login/manager")
                .hasAnyRole("ADMIN","MANAGER")
                .antMatchers("login/employee")
                .hasAnyRole("ADMIN","MANAGER","EMPLOYEE")
                .and()
                .formLogin();
        return httpSecurity.build();
    }
}