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
@Table(name = "TB_REPRESENTANTE")
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class RepresentanteModel extends RepresentationModel<RepresentanteModel> implements Serializable {

	private static final long serialVersionUID = 5490447055673429941L;
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	private String cpf;

	// @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@ManyToOne // (fetch = FetchType.LAZY)
	@JoinColumn(name = "endereco_id", nullable = false)
	private EnderecoModel endereco;

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@OneToMany(mappedBy = "representante", fetch = FetchType.LAZY)
	private Set<AlunoModel> alunos = new HashSet<>();

	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private LocalDateTime dataDeUltimaModificacao;

	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private LocalDateTime dataDeCadastro;

	@PrePersist
	void preInsert() {
		if (this.dataDeUltimaModificacao == null)
			this.dataDeUltimaModificacao = LocalDateTime.now();
		if (this.dataDeCadastro == null)
			this.dataDeCadastro = LocalDateTime.now();
	}

}
