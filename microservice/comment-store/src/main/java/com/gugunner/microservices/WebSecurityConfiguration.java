package com.gugunner.microservices;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .cors()
        .and()
        .csrf()//disable csrf as we do not need it in the sample
        .disable()
        .authorizeRequests()
        .antMatchers("/")
        .hasRole("user")
        .anyRequest().authenticated()
        .and()
        .httpBasic();//allow basic auth
    }
}
