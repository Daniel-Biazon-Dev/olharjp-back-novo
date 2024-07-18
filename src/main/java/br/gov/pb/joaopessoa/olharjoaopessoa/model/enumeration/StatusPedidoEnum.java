package br.gov.pb.joaopessoa.olharjoaopessoa.model.enumeration;

import lombok.Getter;

public enum StatusPedidoEnum {
	OCULOS_PEDIDO ("Óculos Pedido"),
	OCULOS_EM_FABRICACAO("Óculos em fabricação"),
	OCULOS_CONCLUIDO("Óculos Concluído"),
	OCULOS_RECEBIDO("Óculos Recebido"),
	OCULOS_APROVADO("Óculos Aprovado"),
	OCULOS_REPROVADO("Óculos Reprovado");


	@Getter
	private String label;
	
	StatusPedidoEnum(String label) {
		this.label = label;
	}
}
