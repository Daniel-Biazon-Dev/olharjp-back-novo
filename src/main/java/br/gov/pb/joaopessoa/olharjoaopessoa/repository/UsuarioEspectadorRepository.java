package br.gov.pb.joaopessoa.olharjoaopessoa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.pb.joaopessoa.olharjoaopessoa.model.UsuarioEspectadorModel;

public interface UsuarioEspectadorRepository extends JpaRepository<UsuarioEspectadorModel, Long> {
		
}
