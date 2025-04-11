package br.com.fiap.projeto_musica.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "artista")
public class Artista {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "nome_artista")
	private String nome;
	private Integer qtd_albuns;
	private String pais_origem;
	private LocalDate data_fundacao;

	public Artista() {

	}

	public Artista(Long id, String nome, Integer qtd_albuns, String pais_origem, LocalDate data_fundacao) {
		super();
		this.id = id;
		this.nome = nome;
		this.qtd_albuns = qtd_albuns;
		this.pais_origem = pais_origem;
		this.data_fundacao = data_fundacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getQtd_albuns() {
		return qtd_albuns;
	}

	public void setQtd_albuns(Integer qtd_albuns) {
		this.qtd_albuns = qtd_albuns;
	}

	public String getPais_origem() {
		return pais_origem;
	}

	public void setPais_origem(String pais_origem) {
		this.pais_origem = pais_origem;
	}

	public LocalDate getData_fundacao() {
		return data_fundacao;
	}

	public void setData_fundacao(LocalDate data_fundacao) {
		this.data_fundacao = data_fundacao;
	}

}
