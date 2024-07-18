package br.gov.pb.joaopessoa.olharjoaopessoa.dtos.endereco;

public record EnderecoInputDTO(
		String bairro,
		String cep,
		String complemento,
		String numero,
		String rua,
		Long idCidade
		) {

}
