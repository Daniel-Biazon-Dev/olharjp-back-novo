package br.gov.pb.joaopessoa.olharjoaopessoa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.pb.joaopessoa.olharjoaopessoa.model.CidadeModel;

public interface CidadeRepository  extends JpaRepository<CidadeModel, Long>{
	
}