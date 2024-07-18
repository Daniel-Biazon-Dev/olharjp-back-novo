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
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "TB_CIDADE")
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
public class CidadeModel extends RepresentationModel<CidadeModel> implements Serializable {

	private static final long serialVersionUID = -4841867759874188849L;
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	private String uf;
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "cidade", fetch = FetchType.LAZY)
    private Set<EnderecoModel> enderecos = new HashSet<>();

	private LocalDateTime dataDeUltimaModificacao;
	private LocalDateTime dataDeCadastro;
	
	@PrePersist
	void preInsert() {
		if (this.getDataDeCadastro() == null)
			this.setDataDeCadastro(LocalDateTime.now());
		if (this.getDataDeUltimaModificacao() == null)
			this.setDataDeUltimaModificacao(LocalDateTime.now());
	}
}


