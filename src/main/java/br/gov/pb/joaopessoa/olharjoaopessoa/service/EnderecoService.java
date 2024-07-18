package br.gov.pb.joaopessoa.olharjoaopessoa.service;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import br.gov.pb.joaopessoa.olharjoaopessoa.dtos.endereco.EnderecoInputDTO;
import br.gov.pb.joaopessoa.olharjoaopessoa.dtos.endereco.EnderecoViewDTO;
import br.gov.pb.joaopessoa.olharjoaopessoa.exception.EntityConflictException;
import br.gov.pb.joaopessoa.olharjoaopessoa.exception.EntityNotFoundException;
import br.gov.pb.joaopessoa.olharjoaopessoa.model.CidadeModel;
import br.gov.pb.joaopessoa.olharjoaopessoa.model.EnderecoModel;
import br.gov.pb.joaopessoa.olharjoaopessoa.repository.CidadeRepository;
import br.gov.pb.joaopessoa.olharjoaopessoa.repository.EnderecoRepository;
import jakarta.transaction.Transactional;

@Service
public class EnderecoService {
	
	private EnderecoRepository enderecoRepository;
	private CidadeRepository cidadeRepository;
	
	public EnderecoService (
			EnderecoRepository enderecoRepository,
			CidadeRepository cidadeRepository) {
		this.enderecoRepository = enderecoRepository;
		this.cidadeRepository = cidadeRepository;
	}
	
	@Transactional
	public EnderecoViewDTO createEndereco(EnderecoInputDTO enderecoInputDTO) {
		
		CidadeModel cidade = cidadeRepository.findById(enderecoInputDTO.idCidade())
				.orElseThrow(() -> new EntityNotFoundException(""));
		
		if(this.enderecoRepository.existsByCepAndRuaAndNumeroAndComplementoAndBairroAndCidadeId(
				enderecoInputDTO.bairro(), 
				enderecoInputDTO.cep(), 
				enderecoInputDTO.complemento(), 
				enderecoInputDTO.numero(),
				enderecoInputDTO.rua(), 
				enderecoInputDTO.idCidade())) {
			throw new EntityConflictException("Endereço já existe");
		}
		
		EnderecoModel endereco = new EnderecoModel();
		BeanUtils.copyProperties(enderecoInputDTO, endereco);
		endereco.setCidade(cidade);
		endereco = enderecoRepository.save(endereco);
		
		EnderecoViewDTO dto = new EnderecoViewDTO();
		BeanUtils.copyProperties(endereco, dto);
		dto.setCidade(cidade.getNome());
		return dto;
	}
	
//	Validation
	boolean existsByCepAndRuaAndNumeroAndComplementoAndBairroAndCidadeId(
			String cep, String rua, String numero, String complemento, String bairro, Long id) {
		
		return enderecoRepository.existsByCepAndRuaAndNumeroAndComplementoAndBairroAndCidadeId(
				cep, rua, numero, complemento, bairro, id);
	}
	
	EnderecoModel findByCepAndRuaAndNumeroAndComplementoAndBairroAndCidadeId(
			String cep, String rua, String numero, String complemento, String bairro, Long id) {
		
		return enderecoRepository.findByCepAndRuaAndNumeroAndComplementoAndBairroAndCidadeId(
				cep, rua, numero, complemento, bairro, id);
	}
}
