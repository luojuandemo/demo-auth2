package com.smyw.demoauth2.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    @Bean
    public SmywUserDetailsService smywUserDetailsService(){
        return new SmywUserDetailsService();
    }

    @Autowired
    public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(smywUserDetailsService())
                .passwordEncoder(new Md5PasswordEncoder());
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        http
                .anonymous().disable()
                .authorizeRequests()
                .antMatchers("/oauth/token").permitAll();
        // @formatter:on
    }

}
