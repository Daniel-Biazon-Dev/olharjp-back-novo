package br.gov.pb.joaopessoa.olharjoaopessoa.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.pb.joaopessoa.olharjoaopessoa.dtos.endereco.EnderecoInputDTO;
import br.gov.pb.joaopessoa.olharjoaopessoa.service.EnderecoService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/endereco")
public class EnderecoControler {

	private EnderecoService enderecoService;
	
	public EnderecoControler(
			EnderecoService enderecoService) {
		this.enderecoService = enderecoService;
	}
	
	
	@PostMapping
	public ResponseEntity<Object> createEnderco(@RequestBody EnderecoInputDTO enderecoInputDTO){
		return ResponseEntity.status(HttpStatus.CREATED).body(this.enderecoService.createEndereco(enderecoInputDTO));
	}
}
