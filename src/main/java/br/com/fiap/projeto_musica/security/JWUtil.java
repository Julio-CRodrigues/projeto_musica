package br.com.fiap.projeto_musica.security;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JWUtil {
	
	private final SecretKey chave_privada
	= Keys.secretKeyFor(SignatureAlgorithm.HS256);
	
	public String gerarToken(String username) {
		
		Date data_atual = new Date();
		
		JwtBuilder buider = Jwts.builder()
							.subject(username)
							.issuedAt(new Date())
							.expiration(
						new Date(
						data_atual.getTime() + (1000 * 60 * 30)))
							.signWith(chave_privada);
		
		return buider.compact();
		
	}
	
	public String extrairUsername(String token) {
		
		JwtParser parser = Jwts.parser().verifyWith(chave_privada).build();
		
		return parser.parseSignedClaims(token).getPayload().getSubject();
		
	}
	
	public boolean validarToken(String token) {
		
		try {
			
			JwtParser parser = Jwts.parser()
					.verifyWith(chave_privada).build();
			parser.parseSignedClaims(token);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
