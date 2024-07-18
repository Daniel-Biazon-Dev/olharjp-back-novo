package br.gov.pb.joaopessoa.olharjoaopessoa.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.gov.pb.joaopessoa.olharjoaopessoa.model.enumeration.PerfilAcessoEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "TB_USUARIO_ESPECTADOR")
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioEspectadorModel extends RepresentationModel<UsuarioEspectadorModel> implements Serializable {

	private static final long serialVersionUID = -5855108734104533706L;

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	private String cpf;
	
	@Column(columnDefinition = "varchar(50) default 'ESPECTADOR'")
	@Enumerated(EnumType.STRING)
	private PerfilAcessoEnum perfilAcesso; 
	
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private LocalDateTime dataUltimaModificacao;
	
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private LocalDateTime dataCadastro;
	
	@PrePersist
	void preInsert() {
	    if (this.dataUltimaModificacao == null)
	        this.dataUltimaModificacao = LocalDateTime.now();
	    if(this.dataCadastro==null)
	        this.dataCadastro = LocalDateTime.now();
	    if(this.perfilAcesso == null)
	    	this.setPerfilAcesso(PerfilAcessoEnum.ESPECTADOR);
	}
}
