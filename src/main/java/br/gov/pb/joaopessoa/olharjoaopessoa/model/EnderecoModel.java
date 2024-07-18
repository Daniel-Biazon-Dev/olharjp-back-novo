package br.gov.pb.joaopessoa.olharjoaopessoa.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "TB_ENDERECO")
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoModel extends RepresentationModel<EnderecoModel> implements Serializable {

	private static final long serialVersionUID = 781190271237074537L;

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(columnDefinition = "varchar(8)")
	private String cep;
	
	private String rua;
	
	private String numero;
	
	private String complemento;
	
	private String bairro;
	
	//TODO encontrar uma forma de colocar João Pessoa como padrão | "ID Joao Pessoa"
	//@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@ManyToOne//(fetch = FetchType.LAZY)
	@JoinColumn(name = "cidade_id")
	private CidadeModel cidade;	
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@OneToMany(mappedBy = "endereco", fetch = FetchType.LAZY)
	private Set<AlunoModel> alunos = new HashSet<>();
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@OneToMany(mappedBy = "endereco", fetch = FetchType.LAZY)
	private Set<RepresentanteModel> representantes = new HashSet<>();
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@OneToMany(mappedBy = "endereco", fetch = FetchType.LAZY)
	private Set<FacilitadorModel> facilitadores = new HashSet<>();
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@OneToMany(mappedBy = "endereco", fetch = FetchType.LAZY)
	private Set<UnidadeEnsinoModel> unidadeEnsinos = new HashSet<>();
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@OneToMany(mappedBy = "endereco", fetch = FetchType.LAZY)
	private Set<ClinicaModel> clinica = new HashSet<>();
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@OneToMany(mappedBy = "endereco", fetch = FetchType.LAZY)
	private Set<OpticaModel> otica = new HashSet<>();
}
