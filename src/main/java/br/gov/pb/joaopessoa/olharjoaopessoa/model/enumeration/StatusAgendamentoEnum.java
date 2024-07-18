package br.gov.pb.joaopessoa.olharjoaopessoa.model.enumeration;

import lombok.Getter;

public enum StatusAgendamentoEnum {
	ABERTO("Aberto"),
	AGUARDANDO_RETORNO("Aguardando Retorno"),
	CONCLUIDO("Concluído"),
	CANCELADO("Cancelado");

	@Getter
	private String label;
	
	StatusAgendamentoEnum(String label) {
		this.label = label;
	}
}
