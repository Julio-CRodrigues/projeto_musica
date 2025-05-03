package br.com.fiap.projeto_musica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.fiap.projeto_musica.model.Musica;
import br.com.fiap.projeto_musica.projection.MusicaProjection;

public interface MusicaRepository extends JpaRepository<Musica, Long> {
	
	@Query("from Musica mus where mus.internacional = :internacional")
	public List<Musica> retornaMusicasInternacionais(boolean internacional);
	
	
	@Query(nativeQuery = true, 
			value = "select mus.titulo, mus.duracao, art.nome_artista"
			+ " from musica mus inner join artista art on (mus.id_artista = art.id) "
			+ "where mus.duracao >= :duracao order by mus.titulo asc")
	public List<MusicaProjection> retornaMusicasLongaDuracao(Double duracao);
	
	
	@Query(nativeQuery = true, 
			value = "select mus.titulo, mus.duracao, art.nome_artista from musica mus inner "
					+ "join artista art on (mus.id_artista = art.id) "
				  + "where (mus.titulo ilike concat('%',:valor,'%') "
				  + "or lower(art.nome_artista) like lower(concat('%',:valor,'%')))")
	public List<MusicaProjection> retornaMusicasPorSubstring(String valor);

}
