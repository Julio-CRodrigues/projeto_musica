package br.com.fiap.projeto_musica.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class UsuarioConfig {
	
	@Bean
	public UserDetailsService usuario() {
		
		UserDetailsService usuario =
				new InMemoryUserDetailsManager(
				User.withUsername("Julio")
				.password("{noop}senha")
				.roles("USER")
				.build());
				
				return usuario;
	}

}
