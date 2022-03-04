package br.com.estacionamento.controller;


import br.com.estacionamento.modelo.Estacionamento;
import br.com.estacionamento.modelo.veiculos;
import br.com.estacionamento.repository.VeiculosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping ("/veiculos")
public class controllerVeiculos {



    @Autowired
    private VeiculosRepository veiculosRepository;


    @GetMapping
    public List<veiculos> Lista(String nome) {
        List<veiculos> veiculos = veiculosRepository.findAll();
        return veiculos;

    }
    @PostMapping
    @Transactional

    public ResponseEntity<veiculos> cadastrar(@RequestBody @Valid veiculos veiculos, UriComponentsBuilder uriBuilder) {
        veiculos vei = veiculosRepository.save(veiculos);
            URI uri = uriBuilder.path("/veiculos/{id}").buildAndExpand(veiculos.getId()).toUri();
                 return ResponseEntity.created(uri).body(vei);
    }
    @GetMapping("/{id}")
    public Optional<veiculos> detalhar(@PathVariable Long id){
        Optional<veiculos> veiculosById = veiculosRepository.findById(id);
            return veiculosById;
        }





}
