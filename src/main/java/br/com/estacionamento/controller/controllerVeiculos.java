package br.com.estacionamento.controller;

import br.com.estacionamento.modelo.Veiculos;
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
@RequestMapping("/veiculos")
public class controllerVeiculos {


    @Autowired
    private VeiculosRepository VeiculosRepository;


    @GetMapping
    public List<Veiculos> get(String nome) {
        List<Veiculos> veiculos = VeiculosRepository.findAll();
        return veiculos;

    }

    @PostMapping
    @Transactional

    public ResponseEntity<Veiculos> post(@RequestBody @Valid Veiculos veiculos, UriComponentsBuilder uriBuilder) {
        Veiculos vei = VeiculosRepository.save(veiculos);
        URI uri = uriBuilder.path("/veiculos/{id}").buildAndExpand(veiculos.getId()).toUri();
        return ResponseEntity.created(uri).body(vei);
    }

    @GetMapping("/{id}")
    public Optional<Veiculos> getById(@PathVariable Long id) {
        Optional<Veiculos> veiculosById = VeiculosRepository.findById(id);
        return veiculosById;
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Veiculos> update(@PathVariable Long id, @RequestBody @Valid Veiculos updateVeiculos) {
        Veiculos veiculosatt = updateVeiculos.update(id, VeiculosRepository);

        return ResponseEntity.ok(veiculosatt);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        if (VeiculosRepository.existsById(id)) {
            VeiculosRepository.deleteById(id);
        }
    }


}
