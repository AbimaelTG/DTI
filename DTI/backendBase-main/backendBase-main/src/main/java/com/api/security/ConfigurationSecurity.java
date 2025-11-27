package com.api.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.api.security.jwt.JwtEntryPoint;
import com.api.security.jwt.JwtTokenFilter;
import com.api.security.service.UserDetailsServiceImpl;



@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class ConfigurationSecurity{
	
	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;
	
	@Autowired
	private JwtEntryPoint jwtEntryPoint;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	JwtTokenFilter jwtTokenFilter;
	
	@Bean
	public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
    AuthenticationManagerBuilder builder =
            http.getSharedObject(AuthenticationManagerBuilder.class);
    builder.userDetailsService(userDetailsServiceImpl).passwordEncoder(passwordEncoder);
    return builder.build();
}
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		AuthenticationManagerBuilder builder= http.getSharedObject(AuthenticationManagerBuilder.class);
		builder.userDetailsService(userDetailsServiceImpl).passwordEncoder(passwordEncoder);
		

        http.csrf(csrf -> csrf.disable());
		http.cors();
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		http.authorizeHttpRequests().requestMatchers("/auth/**").permitAll()
		.requestMatchers("/assignment/**").permitAll()
		.requestMatchers("/assignments/**").permitAll()
		.requestMatchers("/category/**").authenticated()
		.requestMatchers("/department/**").authenticated()
		.requestMatchers("/dependence/**").authenticated()
		.requestMatchers("/good/**").authenticated()
		.requestMatchers("/ws/**").permitAll()
		.anyRequest().authenticated();
		
		http.exceptionHandling().authenticationEntryPoint(jwtEntryPoint);
		http.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
		return http.build();	
		
	}
	
//	
	

}
