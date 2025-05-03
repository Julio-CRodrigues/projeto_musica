package br.com.fiap.projeto_musica.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SegurancaConfig {
	
	@Bean
	public SecurityFilterChain filtrar(HttpSecurity http) throws Exception {
		
		http.csrf(csrf -> csrf.disable())
						.authorizeRequests(request -> 
						request.
						requestMatchers("/musicas/todas_cacheable","/musicas/todas")
						.permitAll().anyRequest().authenticated())
						.httpBasic(Customizer.withDefaults());
		return http.build();
	}
	
	/*@Bean
	public UserDetailsService usuario() {
		
		UserDetailsService usuario = 
				new InMemoryUserDetailsManager(
				User.withUsername("rennan")
					.password("{noop}senha"));
		
	}*/

}
