package br.gov.pb.joaopessoa.olharjoaopessoa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.pb.joaopessoa.olharjoaopessoa.model.AgendamentoModel;

public interface AgendamentoRepository extends JpaRepository<AgendamentoModel, Long> {
	
}
