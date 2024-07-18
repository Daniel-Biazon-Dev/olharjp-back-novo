package br.gov.pb.joaopessoa.olharjoaopessoa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.pb.joaopessoa.olharjoaopessoa.model.AcompanhamentoModel;

public interface AcompanhamentoRepository extends JpaRepository<AcompanhamentoModel, Long> {
	
}
