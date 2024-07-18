package br.gov.pb.joaopessoa.olharjoaopessoa.model;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashSet;
import java.util.Set;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.gov.pb.joaopessoa.olharjoaopessoa.model.enumeration.StatusAvaliacaoEnum;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@Entity
@Table(name = "TB_AVALICAO")
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
public class AvaliacaoModel extends RepresentationModel<AvaliacaoModel> implements Serializable {

	private static final long serialVersionUID = -1906448439567190881L;

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String codigo;
	
	private boolean autorizacao;
	
	@OneToOne(mappedBy = "avaliacao", cascade = CascadeType.ALL)
    private ReceitaModel receita;
		
	@ManyToOne
	@JoinColumn(name = "aluno_id", nullable = false)
	private AlunoModel aluno;
	
	@ManyToOne
	@JoinColumn(name="oftalmologista_id", nullable=true)
	private OftalmologistaModel oftalmologista;
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@OneToMany(mappedBy = "avaliacao", fetch = FetchType.LAZY)
	private Set<AcompanhamentoModel> acompanhamentos = new HashSet<>();
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@ManyToMany(mappedBy = "avaliacoes", fetch = FetchType.LAZY)
	private Set<FacilitadorModel> facilitadores = new HashSet<>();
	
	@Enumerated(EnumType.STRING)
	private StatusAvaliacaoEnum statusAvaliacao;
	
	private LocalDateTime dataDeUltimaModificacao;
	
	private LocalDateTime dataDeCadastro;
	
	private String codigoGenerator() {
		LocalDateTime localDateTime = LocalDateTime.now();
		Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
		return String.valueOf(instant.toEpochMilli());
	}
	
	@PrePersist
	void preInsert() {
		if (this.getStatusAvaliacao() == null)
			this.setStatusAvaliacao(StatusAvaliacaoEnum.AUTORIZADO);
		if (this.getDataDeCadastro() == null)
			this.setDataDeCadastro(LocalDateTime.now());
		if (this.getDataDeUltimaModificacao() == null)
			this.setDataDeUltimaModificacao(LocalDateTime.now());
		this.codigo = codigoGenerator();
	}
}
