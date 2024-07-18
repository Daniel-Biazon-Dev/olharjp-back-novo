package br.gov.pb.joaopessoa.olharjoaopessoa.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.gov.pb.joaopessoa.olharjoaopessoa.model.enumeration.StatusPedidoEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "TB_PEDIDO")
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class PedidoModel extends RepresentationModel<PedidoModel> implements Serializable {

	private static final long serialVersionUID = -8154950299672191323L;

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@OneToOne//(fetch = FetchType.LAZY)
	@JoinColumn(name = "oculos_id")
	private OculosModel oculos;
	
	@ManyToOne
	@JoinColumn(name="avaliacao_id")
	private AvaliacaoModel avaliacao;
	
	@ManyToOne
	@JoinColumn(name="otica_id", nullable=true)
	private OpticaModel otica;
		
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@OneToMany(mappedBy = "pedido", fetch = FetchType.LAZY)
	private Set<AcompanhamentoModel> acompanhamentos = new HashSet<>();

	private LocalDateTime dataDeUltimaModificacao;
	private LocalDateTime dataDeCadastro;

	@Enumerated(EnumType.STRING)
	private StatusPedidoEnum statusPedido;
	
	@PrePersist
	void preInsert() {
		if (this.dataDeUltimaModificacao == null)
			this.dataDeUltimaModificacao = LocalDateTime.now();
		if (this.dataDeCadastro == null)
			this.dataDeCadastro = LocalDateTime.now();
		if (this.statusPedido == null)
			this.setStatusPedido(StatusPedidoEnum.OCULOS_PEDIDO);

	}
}
