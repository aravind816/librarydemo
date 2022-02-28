package com.dxc.cba.librarydemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
    
    // Create 2 users for demo
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser("user").password("{noop}devil").roles("USER")
                .and()
                .withUser("admin").password("{noop}god").roles("USER", "ADMIN");

    }

    // Secure the endpoins with HTTP Basic authentication
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //HTTP Basic authentication
        http.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/api/book").hasRole("USER")
                .antMatchers(HttpMethod.POST, "/api/book").hasRole("USER")
                .antMatchers(HttpMethod.PUT, "/api/book").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/api/book").hasRole("ADMIN")
                .and()
                .csrf().disable()
                .formLogin().disable();
    }

}
