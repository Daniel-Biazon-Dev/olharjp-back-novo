package br.gov.pb.joaopessoa.olharjoaopessoa.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.hateoas.RepresentationModel;

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
@Table(name = "TB_ACOMPANHAMENTO")
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
public class AcompanhamentoModel extends RepresentationModel<AcompanhamentoModel> implements Serializable {
	
	private static final long serialVersionUID = 2784848167253915639L;

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="avaliacao_id", nullable=false)
	private AvaliacaoModel avaliacao;
	
	@ManyToOne
	@JoinColumn(name="pedido_id")
	private PedidoModel pedido;
	
	@ManyToOne
	@JoinColumn(name="turma_id", nullable=false)
	private TurmaModel turma;
	
	private Integer ano;
	
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
