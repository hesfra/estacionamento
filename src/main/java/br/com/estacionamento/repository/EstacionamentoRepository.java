package br.com.estacionamento.repository;

import br.com.estacionamento.modelo.Estacionamento;
import org.springframework.data.jpa.repository.JpaRepository;



public interface EstacionamentoRepository extends JpaRepository<Estacionamento, Long> {

}
