package br.gov.pb.joaopessoa.olharjoaopessoa.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
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
@Table(name = "TB_DISPONIBILIDADE")
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
public class DisponibilidadeModel extends RepresentationModel<DisponibilidadeModel> implements Serializable {

	private static final long serialVersionUID = 897258086014186644L;

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private LocalDateTime dataAgendamento;

	private boolean disponivel;

	private Integer quantidade;

	@ManyToOne
	@JoinColumn(name = "clinica_id", nullable = false)
	private ClinicaModel clinica;
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@OneToMany
	private Set<AgendamentoModel> agendamentos;
	
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
