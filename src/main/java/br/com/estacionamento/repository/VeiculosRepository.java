package br.com.estacionamento.repository;

import br.com.estacionamento.modelo.veiculos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculosRepository extends JpaRepository<veiculos, Long> {
}
