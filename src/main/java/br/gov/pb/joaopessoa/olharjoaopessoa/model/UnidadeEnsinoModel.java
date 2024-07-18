package br.gov.pb.joaopessoa.olharjoaopessoa.model;

import java.io.Serializable;
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
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "TB_UNIDADE_ENSINO")
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
public class UnidadeEnsinoModel extends RepresentationModel<UnidadeEnsinoModel> implements Serializable {
	
	private static final long serialVersionUID = 475414155705732248L;
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	//@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@ManyToOne//(fetch = FetchType.LAZY)
	@JoinColumn(name = "endereco_id", nullable = false)
	private EnderecoModel endereco;
		
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@OneToMany(mappedBy = "unidadeEnsino", fetch = FetchType.LAZY)
	private Set<FacilitadorModel> facilitadores = new HashSet<>();
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@OneToMany(mappedBy = "unidadeEnsino", fetch = FetchType.LAZY)
	private Set<TurmaModel> turmas = new HashSet<>();
}