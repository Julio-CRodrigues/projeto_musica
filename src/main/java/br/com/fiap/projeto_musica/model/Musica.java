package br.com.fiap.projeto_musica.model;

import java.time.LocalDate;

import org.springframework.hateoas.RepresentationModel;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(description = "Esta classe irá representar a entidade Música")
@Data
@Entity
@Table(name = "musica")
public class Musica extends RepresentationModel<Musica> {

	@Schema(description = "Este atributo representa a chave primária ID", example = "1")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "id_artista")
	private Artista artista;
	@NotEmpty(message = "Não é permitida a inserção de músicas sem título")
	@Size(min = 0, max = 20, message = "Valor inválido para a quantidade de caracteres do título "
			+ "da música")
	private String titulo;
	@DecimalMin("0.5")
	@DecimalMax("60.0")
	private Double duracao;
	@PastOrPresent
	private LocalDate data_lancamento;
	@NotEmpty(message = "Não é permitida a inserção de músicas sem gênero")
	private String genero;
	@Schema(description = "Este atributo representa uma música em um idioma diferente do "
			+ "português",
			example = "true")
	private Boolean internacional;

}
