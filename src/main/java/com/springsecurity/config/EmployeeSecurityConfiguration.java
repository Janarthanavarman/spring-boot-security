package com.springsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class EmployeeSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
        	.antMatchers("/").permitAll()
        	.antMatchers("/menuManagement").hasAnyRole( "ADMIN")
        	.antMatchers("/reportManagement").hasAnyRole( "ADMIN")
        	.antMatchers("/employeeManagement").hasAnyRole( "ADMIN")
        	.antMatchers("/addMenu").hasAnyRole( "ADMIN")
        	.antMatchers("/welcome").hasAnyRole("USER", "ADMIN")
        	.antMatchers("/about").hasAnyRole("USER")
        	.antMatchers("/viewMenu").hasAnyRole("USER", "ADMIN")
        	.antMatchers("/contact").hasAnyRole("USER")
        	.antMatchers("/getEmployees").hasAnyRole("USER", "ADMIN")
            .antMatchers("/addEmployee").hasAnyRole("ADMIN").anyRequest().authenticated()
            
            .and().formLogin().loginPage("/login").permitAll()
            .permitAll().and().logout().permitAll();

        http.csrf().disable();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationMgr) throws Exception {
        authenticationMgr.inMemoryAuthentication()
        .withUser("customer").password("customer")
            .authorities("ROLE_USER").and()
            .withUser("admin").password("admin")
           .authorities("ROLE_ADMIN");
    }

}
