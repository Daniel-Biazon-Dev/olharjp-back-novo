package br.gov.pb.joaopessoa.olharjoaopessoa.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "TB_RECEITA")
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class ReceitaModel extends RepresentationModel<ReceitaModel> implements Serializable {

	private static final long serialVersionUID = -2045955138622113024L;

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String observacao;

	private double odEsfericoPerto;
	private double oeEsfericoPerto;

	private double odEsfericoLonge;
	private double oeEsfericoLonge;

	private double odCilindricoPerto;
	private double oeCilindricoPerto;

	private double odCilindricoLonge;
	private double oeCilindricoLonge;

	private double odEixoPerto;
	private double oeEixoPerto;

	private double odEixoLonge;
	private double oeEixoLonge;

	private double adicao;

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@OneToOne
	@JoinColumn(name = "avaliacao_id", nullable = true)
	private AvaliacaoModel avaliacao;

	@ManyToOne
	@JoinColumn(name = "oftalmologista_id")
	private OftalmologistaModel oftalmologista;

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@OneToOne//(fetch = FetchType.LAZY)
	@JoinColumn(name = "oculos_id")
	private OculosModel oculos;

	private LocalDateTime dataUltimaModificacao;
	private LocalDateTime dataCadastro;

	@PrePersist
	void preInsert() {
		if (this.dataUltimaModificacao == null)
			this.dataUltimaModificacao = LocalDateTime.now();
		if (this.dataCadastro == null)
			this.dataCadastro = LocalDateTime.now();
	}

}