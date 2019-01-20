package com.munifbadr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class Security extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;
    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {

        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select username, Password, enabled"
                        + " from Users where username=?")
                .authoritiesByUsernameQuery("select username, roles "
                        + "from Users where username=?")
                .passwordEncoder(new BCryptPasswordEncoder());
//        auth
//                .inMemoryAuthentication()
//                .withUser("user")
//                .password("password")
//                .roles("USER")
//                .and()
//                .withUser("admin")
//                .password("admin")
//                .roles("USER", "ADMIN")
//                .and()
//                .withUser("Organizer")
//                .password("Organizer")
//                .roles("USER","Organizer");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests().antMatchers("/api/user/add").permitAll().anyRequest().authenticated().and().httpBasic();
//                .authorizeRequests().antMatchers("/users/**").hasAnyRole("USER","ADMIN")
//                .antMatchers("/events","/events/Save").hasAnyRole("ORGANIZER","ADMIN")
//                .antMatchers("/**").hasRole("ADMIN")
                //.antMatchers(HttpMethod.POST,"/events/Save").hasAnyRole("ORGANIZER","ADMIN")
//                .anyRequest()
//                .authenticated()
//                .and()
//                .httpBasic();
    }
}

