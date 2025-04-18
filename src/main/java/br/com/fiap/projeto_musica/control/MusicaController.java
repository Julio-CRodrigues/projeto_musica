package br.com.fiap.projeto_musica.control;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.projeto_musica.dto.MusicaDTO;
import br.com.fiap.projeto_musica.model.Musica;
import br.com.fiap.projeto_musica.projection.MusicaProjection;
import br.com.fiap.projeto_musica.repository.MusicaRepository;
import br.com.fiap.projeto_musica.service.MusicaCachingService;
import br.com.fiap.projeto_musica.service.MusicaService;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
 
 

@RestController
@RequestMapping(value = "/musicas")
public class MusicaController {

	@Autowired
	private MusicaRepository repM;
	
	@Autowired
	private MusicaService servM;
	
	@Autowired
	private MusicaCachingService cacheM;
	
	@GetMapping(value = "/longas")
	public List<MusicaProjection> retornaMusicasLongaDuracao
	(@RequestParam(value = "duracao") Double duracao){
		return repM.retornaMusicasLongaDuracao(duracao);
	}
	
	@GetMapping(value = "/paginadas")
	public ResponseEntity<Page<MusicaDTO>> retornaMusicasPaginadas(
	@RequestParam(value ="page", defaultValue = "0") Integer page, 
	@RequestParam(value = "size", defaultValue = "2") Integer size) {
	
		PageRequest req = PageRequest.of(page, size);
		
		Page<MusicaDTO> musicas_paginadas = servM.paginar(req);
		
		musicas_paginadas.forEach(m -> {
			
			m.add(linkTo(methodOn(MusicaController.class).
					retornaMusicaPorID(m.getId())).withRel("Quer saber mais detalhes sobre a musica de nome " + m.getTitulo() + "? \n"
							+ "clique nesse link: "));
					
					
					m.add(linkTo(methodOn(MusicaController.class)
					.retornaMusicasPaginadas(null, null))
					.withRel("Quer retornar músicas paginadas?"));
					
					
					m.add(linkTo(methodOn(MusicaController.class).inserirMusica(null))
							.withRel("Quer inserir uma nova musica?"));
					
				    m.add(linkTo(methodOn(MusicaController.class)
					.atualizarMusica(m.getId(), null))
					.withRel("quer atualizar a musica de nome: " + m.getTitulo() + "?"));
		});
		
		return ResponseEntity.ok(musicas_paginadas);
		
	}
	

	@GetMapping(value = "/todas")
	public List<Musica> retornaTodasMusicas() {
		return repM.findAll();
	}
	
	@GetMapping(value = "/todas_cacheable")
	public List<Musica> retornaTodasMusicasCacheable(){
		
		List<Musica> todas_musicas = cacheM.findAll();
		
		for(Musica m : todas_musicas) {
			m.add(linkTo(methodOn(MusicaController.class).
					retornaMusicaPorID(m.getId())).withRel("Quer saber mais detalhes sobre a musica de nome " + m.getTitulo() + "? \n"
							+ "clique nesse link: "));
					
					
					m.add(linkTo(methodOn(MusicaController.class)
					.retornaMusicasPaginadas(null, null))
					.withRel("Quer retornar músicas paginadas?"));
					
					
					m.add(linkTo(methodOn(MusicaController.class).inserirMusica(null))
							.withRel("Quer inserir uma nova musica?"));
					
				    m.add(linkTo(methodOn(MusicaController.class)
					.atualizarMusica(m.getId(), null))
					.withRel("quer atualizar a musica de nome: " + m.getTitulo() + "?"));
		}
		
		return todas_musicas;
	}
	
	@GetMapping(value = "/{id}")
	public Musica retornaMusicaPorID(@PathVariable Long id) {

		Optional<Musica> op = cacheM.findById(id);
		
		if(op.isPresent()) {
			return op.get();
		} else {
			throw new 
			ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@GetMapping(value = "/internacionais_nao_otimizadas")
	public List<Musica> retornaMusicasInternacionais(){
		
		List<Musica> todas = repM.findAll();
		List<Musica> internacionais = new ArrayList<Musica>();
		
		for(Musica musica : todas) {
			
			if(musica.getInternacional() == true) {
				internacionais.add(musica);
			}
			
		}
		
		return internacionais;
		
	}
	
	@GetMapping(value = "/internacionais_otimizadas")
	public List<Musica> retornaMusicasInternacionaisOtimizadas(){
		return cacheM.retornaMusicasInternacionais(true);
	}
	
	@PostMapping(value = "/inserir")
	public Musica inserirMusica(@RequestBody Musica musica) {
		repM.save(musica);
		cacheM.limparCache();
		
		musica.add(linkTo(methodOn(MusicaController.class).
				retornaMusicaPorID(musica.getId())).withRel("Ver detalhes ?"));
		
		
		musica.add((linkTo(methodOn(MusicaController.class)
				.atualizarMusica(musica.getId(), null))).withRel("Quer atualizar ?"));
		
		
		
		musica.add(linkTo(methodOn(this.getClass()).retornaTodasMusicasCacheable())
				.withRel("ver todas"));
		return musica;
	}
	
	@PutMapping(value = "/atualizar/{id}")
	public Musica atualizarMusica(@PathVariable Long id, @RequestBody Musica musica) {
		
		Optional<Musica> op = repM.findById(id);
		
		if(op.isPresent()) {
			
			Musica mus_antiga = op.get();
			mus_antiga.setArtista(musica.getArtista());
			mus_antiga.setData_lancamento(musica.getData_lancamento());
			mus_antiga.setGenero(musica.getGenero());
			mus_antiga.setInternacional(musica.getInternacional());
			mus_antiga.setTitulo(musica.getTitulo());
			mus_antiga.setDuracao(musica.getDuracao());
			
			repM.save(mus_antiga);
			cacheM.limparCache();
			
			return mus_antiga;
			
			
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@DeleteMapping(value = "/excluir/{id}")
	public Musica excluirMusica(@PathVariable Long id) {
		
		Optional<Musica> op = repM.findById(id);
		
		if(op.isPresent()) {
			Musica mus_remover = op.get();
			repM.delete(mus_remover);
			cacheM.limparCache();
			return mus_remover;
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
	}
	
	
	@GetMapping(value = "/substring")
	public List<MusicaProjection> retornaMusicaPorSubstring(@RequestParam(value = "parametro") String valor){
		return repM.retornaMusicasPorSubstring(valor);
	}

}
