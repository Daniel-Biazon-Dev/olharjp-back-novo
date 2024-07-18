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
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "TB_ALUNO")
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class AlunoModel extends UsuarioModel implements Serializable {

	private static final long serialVersionUID = -3845198399589411746L;

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	private LocalDate dataDeNascimento;

	@Column(length = 11, nullable = false, unique = true)
	private String cpf;

	@Column(nullable = false, unique = true)
	private String cartaoSUS;

	@Column(columnDefinition = "varchar(100)")
	private String email;

	// @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@ManyToOne // (fetch = FetchType.LAZY)
	@JoinColumn(name = "endereco_id", nullable = false)
	private EnderecoModel endereco;

	@ManyToOne
	@JoinColumn(name = "representante_id", nullable = false)
	private RepresentanteModel representante;

	@ManyToOne
	@JoinColumn(name = "turma_id", nullable = false)
	private TurmaModel turma;

	@ManyToOne
	@JoinColumn(name = "authUser_id", nullable = false)
	private AuthUserModel authUser;
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@OneToMany(mappedBy = "aluno", fetch = FetchType.LAZY)
	private Set<AgendamentoModel> agendamentos = new HashSet<>();

	@ManyToMany
	@JoinTable(
		name = "tb_aluno_facilitador", 
		joinColumns = @JoinColumn(name = "aluno_id"), 
		inverseJoinColumns = @JoinColumn(name = "facilitador_id"))
	private Set<FacilitadorModel> facilitadores = new HashSet<>();
	
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	@OneToMany(mappedBy = "aluno", fetch = FetchType.LAZY)
	private Set<AvaliacaoModel> avaliacao;
	
	@Override
	@PrePersist
	void preInsert() {
		if (this.getPerfilAcesso() == null)
			this.setPerfilAcesso(PerfilAcessoEnum.ALUNO);
		if (this.getDataDeCadastro() == null)
			this.setDataDeCadastro(LocalDateTime.now());
		if (this.getDataDeUltimaModificacao() == null)
			this.setDataDeUltimaModificacao(LocalDateTime.now());
	}
}
