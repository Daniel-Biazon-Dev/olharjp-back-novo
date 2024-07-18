package br.gov.pb.joaopessoa.olharjoaopessoa.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "TB_TURMA")
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class TurmaModel extends RepresentationModel<TurmaModel> implements Serializable {

	private static final long serialVersionUID = 1146061332733598697L;

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String serie;

	private String turma;

	@ManyToOne
	@JoinColumn(name = "unidadeEnsino_id", nullable = false)
	private UnidadeEnsinoModel unidadeEnsino;

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@OneToMany(mappedBy = "turma", fetch = FetchType.LAZY)
	private Set<AcompanhamentoModel> acompanhamentos = new HashSet<>();

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