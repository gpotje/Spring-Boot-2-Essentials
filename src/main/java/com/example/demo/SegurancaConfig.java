//package com.example.demo;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
//import org.springframework.web.cors.CorsConfiguration;
//
//@EnableWebSecurity
//@EnableAuthorizationServer
//@EnableResourceServer
//public class SegurancaConfig extends WebSecurityConfigurerAdapter{
//	
//	@Bean
//	@Override
//	protected AuthenticationManager authenticationManager() throws Exception {
//		return super.authenticationManager();
//	}
//	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("gpot").password("abc123").roles("ADMIN");
//		auth.inMemoryAuthentication().withUser("padovinha").password("def456").roles("ADMIN");
//	}
//	
//	
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return NoOpPasswordEncoder.getInstance();
//	}
//
//	@Override
//	public void configure(WebSecurity web) {
//		web.ignoring().antMatchers(
//				"/v2/api-docs", 
//                "/configuration/ui", 
//                "/swagger-resources/**",
//                "/configuration/security", 
//                "/swagger-ui.html", 
//                "/webjars/**",
//                "http://localhost:3000/**"
//				);
//	}
//
////	@Override
////	protected void configure(HttpSecurity http) throws Exception {
////		http.cors().configurationSource(RequestBody -> new CorsConfiguration().applyPermitDefaultValues())
////		.and()
////		.csrf().disable();
////	}
//	
//	
//}
