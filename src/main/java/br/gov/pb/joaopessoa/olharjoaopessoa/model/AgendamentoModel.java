package br.gov.pb.joaopessoa.olharjoaopessoa.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.hateoas.RepresentationModel;

import br.gov.pb.joaopessoa.olharjoaopessoa.model.enumeration.StatusAgendamentoEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "TB_AGENDAMENTO")
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class AgendamentoModel extends RepresentationModel<AgendamentoModel> implements Serializable {

	private static final long serialVersionUID = -7251339349457128927L;

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private LocalDateTime dataAgendamento;

	private String observacao;

	@ManyToOne // (fetch = FetchType.LAZY)
	@JoinColumn(name = "clinica_id")
	private ClinicaModel clinica;

	@ManyToOne
	@JoinColumn(name = "aluno_id", nullable = true)
	private AlunoModel aluno;
	
	@ManyToOne
	@JoinColumn(name = "disponibilidade_id", nullable = true)
	private DisponibilidadeModel disponibilidade;

	@Enumerated(EnumType.STRING)
	private StatusAgendamentoEnum statusAgendamento;

	private LocalDateTime dataDeUltimaModificacao;
	private LocalDateTime dataDeCadastro;

	@PrePersist
	void preInsert() {
		if (this.getStatusAgendamento() == null)
			this.setStatusAgendamento(StatusAgendamentoEnum.ABERTO);
		if (this.getDataDeCadastro() == null)
			this.setDataDeCadastro(LocalDateTime.now());
		if (this.getDataDeUltimaModificacao() == null)
			this.setDataDeUltimaModificacao(LocalDateTime.now());
	}
}
