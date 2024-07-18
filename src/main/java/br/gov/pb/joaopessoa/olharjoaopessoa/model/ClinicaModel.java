package br.gov.pb.joaopessoa.olharjoaopessoa.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.gov.pb.joaopessoa.olharjoaopessoa.model.enumeration.PerfilAcessoEnum;
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
@Table(name = "TB_CLINICA")
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
public class ClinicaModel extends UsuarioModel implements Serializable {
	
	private static final long serialVersionUID = -2531676486844290777L;

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String razaoSocial;
	
	private String nomeFantasia;
	
	private String email;
	
	private String cnpj;

	@ManyToOne
	@JoinColumn(name="endereco_id", nullable=false)
	private EnderecoModel endereco;
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@OneToMany(mappedBy = "clinica", fetch = FetchType.LAZY)
	private Set<OftalmologistaModel> oftalmologista = new HashSet<>();
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@OneToMany(mappedBy = "clinica", fetch = FetchType.LAZY)
	private Set<AgendamentoModel> agendamentos = new HashSet<>();
	
	@ManyToOne
	@JoinColumn(name="authUser_id", nullable=false)
	private AuthUserModel authUser;
	
	@Override
	@PrePersist
	void preInsert() {
		if (this.getPerfilAcesso() == null)
			this.setPerfilAcesso(PerfilAcessoEnum.CLINICA);
		if (this.getDataDeCadastro() == null)
			this.setDataDeCadastro(LocalDateTime.now());
		if (this.getDataDeUltimaModificacao() == null)
			this.setDataDeUltimaModificacao(LocalDateTime.now());
	}
}
