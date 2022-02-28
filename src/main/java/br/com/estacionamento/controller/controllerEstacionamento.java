package br.com.estacionamento.controller;


import br.com.estacionamento.modelo.Estacionamento;
import br.com.estacionamento.repository.EstacionamentoRepository;
import br.com.estacionamento.repository.VeiculosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.Id;
import javax.transaction.Transactional;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping ("/estacionamento")
public class controllerEstacionamento {


    @Autowired
    private EstacionamentoRepository EstacionamentoRepository;

    @Autowired
    private VeiculosRepository veiculosRepository;

    //@GetMapping
    //public class EstacionamentoRepository{

    //}

    ;

    @GetMapping
    public List<Estacionamento> lista(String nome) {
        List<Estacionamento> Estacionamentos = EstacionamentoRepository.findAll();
            return Estacionamentos;
    }

    @PostMapping
    @Transactional

    public ResponseEntity<Estacionamento> cadastrar(@RequestBody Estacionamento Estacionamento, UriComponentsBuilder  uriBuilder){
        System.out.println(Estacionamento);
        EstacionamentoRepository.save(Estacionamento);


            URI uri = uriBuilder.path("/estacionamento/{id}").buildAndExpand(Estacionamento.getId()).toUri();
            return ResponseEntity.created(uri).body(new Estacionamento(Estacionamento));


    }

    }


