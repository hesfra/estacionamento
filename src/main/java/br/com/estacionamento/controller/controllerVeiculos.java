package br.com.estacionamento.controller;


import br.com.estacionamento.modelo.veiculos;
import br.com.estacionamento.repository.EstacionamentoRepository;
import br.com.estacionamento.repository.VeiculosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping ("/veiculos")
public class controllerVeiculos {


    @Autowired
    private EstacionamentoRepository estacionamentoRepository;

    @Autowired
    private VeiculosRepository veiculosRepository;


    @GetMapping
    public List<veiculos> Lista() {
        veiculos Veiculos = new veiculos();
        List<veiculos> veiculos = veiculosRepository.findAll();
        return veiculos;

    }
}
