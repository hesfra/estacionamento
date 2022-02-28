package br.com.estacionamento.repository;

import br.com.estacionamento.modelo.Estacionamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface EstacionamentoRepository extends JpaRepository<Estacionamento, Long> {

}
