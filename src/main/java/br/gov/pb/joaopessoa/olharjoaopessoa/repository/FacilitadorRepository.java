package br.gov.pb.joaopessoa.olharjoaopessoa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.pb.joaopessoa.olharjoaopessoa.model.FacilitadorModel;

public interface FacilitadorRepository extends JpaRepository<FacilitadorModel, Long> {
	
}
