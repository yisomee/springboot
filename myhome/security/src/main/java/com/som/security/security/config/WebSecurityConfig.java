package com.som.security.security.config;

import com.som.security.security.authentication.WebAuthenticationProvider;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	private final WebAuthenticationProvider webAuthenticationProvider;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/").permitAll()
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/account/login")
				.successHandler(new LoginSuccessHandler("/"))
				.permitAll()
				.and()
			.logout()
				.permitAll()
				.and()
			.csrf().disable();
	}
	@Override
    protected void configure(AuthenticationManagerBuilder auth) {
		// .withUser("user1").password(passwordEncoder().encode("1234")).roles("USER")
        // .and()
		// .withUser("admin").password(passwordEncoder().encode("1234")).roles("ADMIN");
        auth.authenticationProvider(this.webAuthenticationProvider);
    }



	// @Bean
	// @Override
	// public UserDetailsService userDetailsService() {
	// 	UserDetails user =
	// 		 User.withDefaultPasswordEncoder()
	// 			.username("user")
	// 			.password("password")
	// 			.roles("USER")
	// 			.build();

	// 	return new InMemoryUserDetailsManager(user);
	// }
}