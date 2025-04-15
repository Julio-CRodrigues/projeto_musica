package br.com.fiap.projeto_musica.dto;

import java.time.LocalDate;

import org.springframework.hateoas.RepresentationModel;

import br.com.fiap.projeto_musica.model.Artista;
import br.com.fiap.projeto_musica.model.Musica;

public class MusicaDTO extends RepresentationModel<MusicaDTO> {

	private Long id;
	private Artista artista;
	private String titulo;
	private Double duracao;
	private LocalDate dataLancamento;
	private String genero;
	private boolean internacional;
	
	public MusicaDTO() {
		
	}
	
	public MusicaDTO(Musica musica) {
		this.id = musica.getId();
		this.artista = musica.getArtista();
		this.titulo = musica.getTitulo();
		this.duracao = musica.getDuracao();
		this.dataLancamento = musica.getData_lancamento();
		this.genero = musica.getGenero();
		this.internacional = musica.getInternacional();
	}

	public MusicaDTO(Long id, Artista artista, String titulo, Double duracao, LocalDate dataLancamento, String genero,
			boolean internacional) {
		super();
		this.id = id;
		this.artista = artista;
		this.titulo = titulo;
		this.duracao = duracao;
		this.dataLancamento = dataLancamento;
		this.genero = genero;
		this.internacional = internacional;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Artista getArtista() {
		return artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Double getDuracao() {
		return duracao;
	}

	public void setDuracao(Double duracao) {
		this.duracao = duracao;
	}

	public LocalDate getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(LocalDate dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public boolean isInternacional() {
		return internacional;
	}

	public void setInternacional(boolean internacional) {
		this.internacional = internacional;
	}

}
