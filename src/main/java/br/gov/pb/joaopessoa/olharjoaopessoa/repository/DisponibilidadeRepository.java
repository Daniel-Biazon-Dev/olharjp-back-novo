package br.gov.pb.joaopessoa.olharjoaopessoa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.pb.joaopessoa.olharjoaopessoa.model.DisponibilidadeModel;

public interface DisponibilidadeRepository extends JpaRepository<DisponibilidadeModel, Long> {
	
}
