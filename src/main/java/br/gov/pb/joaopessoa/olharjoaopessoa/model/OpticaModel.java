package br.gov.pb.joaopessoa.olharjoaopessoa.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import br.gov.pb.joaopessoa.olharjoaopessoa.model.enumeration.PerfilAcessoEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "TB_OPTICA")
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
public class OpticaModel  extends UsuarioModel implements Serializable {

	private static final long serialVersionUID = 7897884928523226481L;

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String cnpj;
	
	private String razaoSocial;
	
	private String nomeFantasia;
	
	@ManyToOne
	@JoinColumn(name = "endereco_id", nullable = false)
	private EnderecoModel endereco;

	@ManyToOne
	@JoinColumn(name="authUser_id", nullable=false)
	private AuthUserModel authUser;
	
	@Override
	@PrePersist
	void preInsert() {
		if (this.getPerfilAcesso() == null)
			this.setPerfilAcesso(PerfilAcessoEnum.OTICA);
		if (this.getDataDeCadastro() == null)
			this.setDataDeCadastro(LocalDateTime.now());
		if (this.getDataDeUltimaModificacao() == null)
			this.setDataDeUltimaModificacao(LocalDateTime.now());
	}
}
