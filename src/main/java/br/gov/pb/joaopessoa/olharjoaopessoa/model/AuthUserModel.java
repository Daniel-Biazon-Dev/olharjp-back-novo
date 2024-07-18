package br.gov.pb.joaopessoa.olharjoaopessoa.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.gov.pb.joaopessoa.olharjoaopessoa.model.enumeration.PerfilAcessoEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "TB_AUTH_USER")
@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
public class AuthUserModel implements Serializable{

	private static final long serialVersionUID = -3583258764828843626L;
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String username;
	private String usernameSus;
	private String usernameCpf;
	private String password;
	
	@Enumerated(EnumType.STRING)
	private PerfilAcessoEnum perfilAcesso;
	
	private Long userId;
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@OneToMany(mappedBy = "authUser", fetch = FetchType.LAZY)
	private Set<AlunoModel> alunos = new HashSet<>();
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@OneToMany(mappedBy = "authUser", fetch = FetchType.LAZY)
	private Set<FacilitadorModel> facilitadores = new HashSet<>();
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@OneToMany(mappedBy = "authUser", fetch = FetchType.LAZY)
	private Set<ClinicaModel> clinicas = new HashSet<>();
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@OneToMany(mappedBy = "authUser", fetch = FetchType.LAZY)
	private Set<OpticaModel> opticas = new HashSet<>();
	
	private LocalDateTime dataDeCadastro;
	private LocalDateTime dataDeUltimaModificacao;
	
	@PrePersist
	void preInsert() {
		if (this.getDataDeCadastro() == null)
			this.setDataDeCadastro(LocalDateTime.now());
		if (this.getDataDeUltimaModificacao() == null)
			this.setDataDeUltimaModificacao(LocalDateTime.now());
	}
}