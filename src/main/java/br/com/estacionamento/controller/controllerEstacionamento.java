package br.com.estacionamento.controller;


import br.com.estacionamento.modelo.Estacionamento;
import br.com.estacionamento.repository.EstacionamentoRepository;
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
@RequestMapping("/estacionamento")
public class controllerEstacionamento {


    @Autowired
    private EstacionamentoRepository EstacionamentoRepository;


    @GetMapping
    public List<Estacionamento> get(String nome) {
        List<Estacionamento> Estacionamentos = EstacionamentoRepository.findAll();
        System.out.println(Estacionamentos);
        return Estacionamentos;
    }

    @PostMapping
    @Transactional

    public ResponseEntity<Estacionamento> post(@RequestBody @Valid Estacionamento Estacionamento, UriComponentsBuilder uriBuilder) {

        Estacionamento est = EstacionamentoRepository.save(Estacionamento);


        URI uri = uriBuilder.path("/estacionamento/{id}").buildAndExpand(Estacionamento.getId()).toUri();
        return ResponseEntity.created(uri).body(est);
    }

    @GetMapping("/{id}")
    public Optional<Estacionamento> getById(@PathVariable Long id) {
        Optional<Estacionamento> estacionamentoById = EstacionamentoRepository.findById(id);
        return estacionamentoById;
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Estacionamento> update(@PathVariable Long id, @RequestBody @Valid Estacionamento updateEstacionamento) {
        Estacionamento estacionamentoatt = updateEstacionamento.update(id, EstacionamentoRepository);
        return ResponseEntity.ok(estacionamentoatt);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        if (EstacionamentoRepository.existsById(id)) {
            EstacionamentoRepository.deleteById(id);
        }
    }
}


