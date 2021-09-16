package com.example.demo.configuration;

import javax.annotation.security.PermitAll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.example.demo.service.CustomUserDetailService;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	GoogleOAuth2SucessHandler googleOAuth2SucessHandler;
	
	@Autowired
	CustomUserDetailService customUserDetailService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.authorizeRequests()
				.antMatchers("/","/shop/**","/register","/forgot_email_form/**","/password_change_form","/send-otp","/change-password","/verify-otp","/verify_otp", "/mysql-console/**").permitAll()
				.antMatchers("/admin/**").hasRole("ADMIN")
				.antMatchers("/vendor/**").hasRole("VENDOR")
				.anyRequest()
				.authenticated()
				.and()
				.formLogin()
				.loginPage("/login")
				.permitAll()
				.failureUrl("/login?error= true")
				.defaultSuccessUrl("/")
				.usernameParameter("email")
				.passwordParameter("password")
				.and()
				.oauth2Login()
				.loginPage("/login")
				.successHandler(googleOAuth2SucessHandler)
				.and()
				.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/login")
				.invalidateHttpSession(true)
				.deleteCookies("JSESSIONID")
				.and()
				.exceptionHandling()
				.and()
				.csrf()
				.disable();
		http.headers().frameOptions().disable();
		
	
	}
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserDetailService);
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**", "/static/**", "/images/**", "/productImages/**", "/css/**", "/js/**");
	}
	
}
