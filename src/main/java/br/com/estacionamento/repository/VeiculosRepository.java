package br.com.estacionamento.repository;

import br.com.estacionamento.modelo.Veiculos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculosRepository extends JpaRepository<Veiculos, Long> {
}
