package br.gov.pb.joaopessoa.olharjoaopessoa.model.enumeration;

import lombok.Getter;

public enum PerfilAcessoEnum {
	PROFISSIONAL_EDUCACAO("Profissional Educação"),
	PROFISSIONAL_SAUDE("Profissional de Saúde"),
	ESPECTADOR("Espectador"),
	ALUNO("Aluno"),
	OTICA("Ótica"),
	CLINICA("Clínica"),
	ADMIN("Admin");

	@Getter
	private String label;
	
	PerfilAcessoEnum(String label) {
		this.label = label;
	}
	
}
