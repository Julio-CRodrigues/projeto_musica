package br.com.fiap.projeto_musica.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.fiap.projeto_musica.model.Musica;
import br.com.fiap.projeto_musica.repository.MusicaRepository;

@Service
public class MusicaCachingService {

	@Autowired
	private MusicaRepository repM;
	
	@Cacheable(value = "retornaMusicasInternacionais", key="#valor")
	public List<Musica> retornaMusicasInternacionais(boolean valor){
		return repM.retornaMusicasInternacionais(valor);
	}

	@Cacheable(value = "buscaTodasMusicas")
	public List<Musica> findAll() {
		return repM.findAll();
	}

	@Cacheable(value = "buscaMusicaPorID", key = "#id_musica")
	public Optional<Musica> findById(Long id_musica) {
		return repM.findById(id_musica);
	}

	@Cacheable(value = "buscaPaginasMusica", key = "#req")
	public Page<Musica> findAll(PageRequest req) {
		return repM.findAll(req);
	}

	@CacheEvict(value = {"retornaMusicasInternacionais", "buscaTodasMusicas", 
			"buscaMusicaPorID", "buscaPaginasMusica"}, allEntries = true)
	public void limparCache() {
		System.out.println("Limpando o cache!");
	}

}
