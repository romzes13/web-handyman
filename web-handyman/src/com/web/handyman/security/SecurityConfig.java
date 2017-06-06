package com.web.handyman.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;

@EnableWebSecurity
public class SecurityConfig {

   /* @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
        auth.inMemoryAuthentication().withUser("admin").password("1").roles("USER","ADMIN");
        
    }*/
    
    @Autowired
    DataSource dataSource;
 
    // .usersByUsernameQuery("select user_name,user_password, enabled from users where username=?")
    // .authoritiesByUsernameQuery("select username, role from user_roles where username=?");
    
    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select user_name,user_password, enabled from user where user_name=?")
                .authoritiesByUsernameQuery("select user_name, role from user_roles where user_name=?");
    }
    
    
    
    
    protected void configure(HttpSecurity http) throws Exception {
    	/*http
    		.authorizeRequests()
    			.anyRequest().authenticated()
    			.and()
    		.formLogin()
    			.loginPage("/login") 
    			.permitAll(); */       
    	
    	/*http.authorizeRequests().antMatchers("/", "/home").permitAll().antMatchers("/admin/**").hasRole("ADMIN")
        .anyRequest().authenticated().and().formLogin().loginPage("/login").permitAll().and().logout()
        .permitAll();
    	http.exceptionHandling().accessDeniedPage("/403");*/
    	
    	
    	 http.authorizeRequests()
 		.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
 		.and()
 		  .formLogin().loginPage("/login").failureUrl("/login?error")
 		  .usernameParameter("username").passwordParameter("password")
 		.and()
 		  .logout().logoutSuccessUrl("/login?logout")
 		.and()
 		  .exceptionHandling().accessDeniedPage("/403")
 		.and()
 		  .csrf();
    	
    	
    	
    	
    	/*http
		.logout()                                                                
			.logoutUrl("/logout")                                                 
			.logoutSuccessUrl("/index")                                           
			.logoutSuccessHandler(logoutSuccessHandler)                              
			.invalidateHttpSession(true)                                             
			.addLogoutHandler(logoutHandler)                                         
			.deleteCookies(cookieNamesToClear)                                       
			.and();*/
    	
    	
    }
    
    /*@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/", "/home").permitAll().antMatchers("/admin").hasRole("ADMIN")
                .anyRequest().authenticated().and().formLogin().loginPage("/login").permitAll().and().logout()
                .permitAll();
        http.exceptionHandling().accessDeniedPage("/403");
    }*/
    
}