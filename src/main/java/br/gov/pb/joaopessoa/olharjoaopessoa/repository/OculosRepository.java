package br.gov.pb.joaopessoa.olharjoaopessoa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.pb.joaopessoa.olharjoaopessoa.model.OculosModel;

public interface OculosRepository extends JpaRepository<OculosModel, Long> {
	
}
