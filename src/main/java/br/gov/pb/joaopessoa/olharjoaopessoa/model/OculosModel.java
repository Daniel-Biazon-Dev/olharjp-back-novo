package br.gov.pb.joaopessoa.olharjoaopessoa.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.hateoas.RepresentationModel;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "TB_OCULOS")
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
public class OculosModel  extends RepresentationModel<OculosModel> implements Serializable {
		
	private static final long serialVersionUID = 4151658371085168980L;

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String modelo;
	
	private String cor;
	
	@OneToOne(mappedBy = "oculos", cascade = CascadeType.ALL)
	private ReceitaModel receita;

	@OneToOne(mappedBy = "oculos", cascade = CascadeType.ALL)
	private PedidoModel pedido;
	
	@ManyToOne
	@JoinColumn(name="aluno_id", nullable=true)
	private AlunoModel aluno;
	
	private LocalDateTime dataUltimaModificacao;
	private LocalDateTime dataCadastro;
	
	@PrePersist
	void preInsert() {
	    if (this.dataUltimaModificacao == null)
	        this.dataUltimaModificacao = LocalDateTime.now();
	    if(this.dataCadastro==null)
	        this.dataCadastro = LocalDateTime.now();
	}
}
