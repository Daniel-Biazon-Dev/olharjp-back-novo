package br.gov.pb.joaopessoa.olharjoaopessoa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.pb.joaopessoa.olharjoaopessoa.model.EnderecoModel;

public interface EnderecoRepository  extends JpaRepository<EnderecoModel, Long> {
	
	boolean existsByCepAndRuaAndNumeroAndComplementoAndBairroAndCidadeId(
			String cep, String rua, String numero, String complemento, String bairro, Long id);
	
	EnderecoModel findByCepAndRuaAndNumeroAndComplementoAndBairroAndCidadeId(
			String cep, String rua, String numero, String complemento, String bairro, Long id);
}
