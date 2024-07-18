package br.gov.pb.joaopessoa.olharjoaopessoa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.pb.joaopessoa.olharjoaopessoa.model.AlunoModel;

public interface AlunoRepository extends JpaRepository<AlunoModel, Long> {
	
}
