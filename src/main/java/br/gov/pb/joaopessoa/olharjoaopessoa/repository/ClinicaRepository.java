package br.gov.pb.joaopessoa.olharjoaopessoa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.pb.joaopessoa.olharjoaopessoa.model.ClinicaModel;

public interface ClinicaRepository extends JpaRepository<ClinicaModel, Long> {
	
}
