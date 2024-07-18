package br.gov.pb.joaopessoa.olharjoaopessoa.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.gov.pb.joaopessoa.olharjoaopessoa.model.enumeration.PerfilAcessoEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "TB_FACILITADOR")
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class FacilitadorModel extends UsuarioModel implements Serializable {

	private static final long serialVersionUID = 7170329177809788886L;

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	@Column(columnDefinition = "varchar(100)")
	private String email;

	@Column(length = 11, nullable = false, unique = true)
	private String cpf;

	private LocalDate dataDeNascimento;

	// @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@ManyToOne // (fetch = FetchType.LAZY)
	@JoinColumn(name = "unidadeEnsino_id", nullable = false)
	private UnidadeEnsinoModel unidadeEnsino;

	@ManyToOne
	@JoinColumn(name = "endereco_id", nullable = false)
	private EnderecoModel endereco;

	@ManyToOne
	@JoinColumn(name = "authUser_id", nullable = false)
	private AuthUserModel authUser;

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@ManyToMany(mappedBy = "facilitadores", fetch = FetchType.LAZY)
	private Set<AlunoModel> alunos = new HashSet<>();
	
	@ManyToMany
	@JoinTable(
		name = "tb_facilitador_avaliacao", 
		joinColumns = @JoinColumn(name = "facilitador_id"), 
		inverseJoinColumns = @JoinColumn(name = "avaliacao_id"))
	private Set<AvaliacaoModel> avaliacoes = new HashSet<>();

	@Override
	@PrePersist
	void preInsert() {
		if (this.getPerfilAcesso() == null)
			this.setPerfilAcesso(PerfilAcessoEnum.PROFISSIONAL_EDUCACAO);
		if (this.getDataDeCadastro() == null)
			this.setDataDeCadastro(LocalDateTime.now());
		if (this.getDataDeUltimaModificacao() == null)
			this.setDataDeUltimaModificacao(LocalDateTime.now());
	}
}
