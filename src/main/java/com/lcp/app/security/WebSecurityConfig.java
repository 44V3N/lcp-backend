package com.lcp.app.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.security.config.Customizer;
import static org.springframework.security.config.Customizer.withDefaults;

import java.util.List;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http ) throws Exception {
		
			
		http
			.cors(Customizer.withDefaults())
			.authorizeHttpRequests( authorize -> authorize
				.anyRequest().permitAll() )
			.csrf(csrf -> csrf.disable()) // deshabilitando lka protección Cross-Site Request Forgery		
			.httpBasic( withDefaults() ); // habilitando la autenticación básica http
		return http.build();
	}
	
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins( List.of("http://127.0.0.1:5173","https://lcp-backend.onrender.com","*") );
		configuration.setAllowedMethods( List.of("GET", "POST", "PUT", "DELETE") );
		configuration.setAllowedHeaders( List.of("Authorization","Content-Type") );
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
		
	}
	
	@Bean
	UserDetailsService userDetailsService() {
		
		UserDetails edwin = User.builder()
				.username("edwin@ninja.com")
//				.password( passwordEncoder().encode("123")   )
				.password( "{noop}456"  )
				.roles("ADMIN")
				.build();
				
		UserDetails lalo = User.builder()
				.username("eduardo")
				.password("{noop}456")
//				.password( passwordEncoder().encode("456")   )
				.roles("CUSTOMER", "SAYAJIN") // "ROLE_CUSTOMER"
				.build();
		
		return new InMemoryUserDetailsManager( edwin, lalo)  ;
	}
	
}
