package br.gov.pb.joaopessoa.olharjoaopessoa.model.enumeration;

import lombok.Getter;

public enum StatusAvaliacaoEnum {
	AUTORIZADO("Autorizado"),
	NÃO_AUTORIZADO("Não Autorizado"),
	CONSULTA_AGENDADA("Consulta Agendada"),
	CONSULTA_CONCLUIDA("Consulta Conluida"),
	AGUARDANDO_RETORNO("Aguardando Retorno"),
	AGENDAMENTO_RETORNO("Agendamento Retorno"),
	OCULOS_APROVADO("Óculos Aprovado"),
	OCULOS_REPROVADO("Óculos Reprovado"),
	CONCLUIDO("Concluído");

	@Getter
	private String label;
	
	StatusAvaliacaoEnum(String label) {
		this.label = label;
	}
	
}
