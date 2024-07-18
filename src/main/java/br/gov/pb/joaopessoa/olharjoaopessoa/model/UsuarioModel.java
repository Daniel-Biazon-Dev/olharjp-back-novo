package br.gov.pb.joaopessoa.olharjoaopessoa.model;

import java.time.LocalDateTime;

import org.springframework.hateoas.RepresentationModel;

import br.gov.pb.joaopessoa.olharjoaopessoa.model.enumeration.PerfilAcessoEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class UsuarioModel extends RepresentationModel<UsuarioModel> {

	private String username;
	private String usernameCpf;
	private String usernameSus;
	private String password;

	@Enumerated(EnumType.STRING)
	private PerfilAcessoEnum perfilAcesso;
	
	private LocalDateTime dataDeCadastro;
	private LocalDateTime dataDeUltimaModificacao;

	@PrePersist
	void preInsert() {
		
	}
}
