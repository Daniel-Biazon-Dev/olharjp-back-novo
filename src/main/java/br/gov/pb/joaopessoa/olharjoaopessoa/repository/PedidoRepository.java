package br.gov.pb.joaopessoa.olharjoaopessoa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.pb.joaopessoa.olharjoaopessoa.model.PedidoModel;

public interface PedidoRepository extends JpaRepository<PedidoModel, Long> {

}
