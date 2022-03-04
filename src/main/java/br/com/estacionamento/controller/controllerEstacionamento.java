package br.com.estacionamento.controller;


import br.com.estacionamento.form.AtualizacaoEstacionamento;
import br.com.estacionamento.modelo.Estacionamento;
import br.com.estacionamento.repository.EstacionamentoRepository;
import br.com.estacionamento.repository.VeiculosRepository;
import net.bytebuddy.dynamic.DynamicType;
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
@RequestMapping ("/estacionamento")
public class controllerEstacionamento {


    @Autowired
    private EstacionamentoRepository EstacionamentoRepository;

    @Autowired
    private VeiculosRepository veiculosRepository;


    @GetMapping
    public List<Estacionamento> lista(String nome) {
        List<Estacionamento> Estacionamentos = EstacionamentoRepository.findAll();
        System.out.println(Estacionamentos);
        return Estacionamentos;
    }

    @PostMapping
    @Transactional

    public ResponseEntity<Estacionamento> cadastrar(@RequestBody @Valid Estacionamento Estacionamento, UriComponentsBuilder uriBuilder) {

        Estacionamento est = EstacionamentoRepository.save(Estacionamento);


        URI uri = uriBuilder.path("/estacionamento/{id}").buildAndExpand(Estacionamento.getId()).toUri();
        return ResponseEntity.created(uri).body(est);
    }

        @GetMapping("/{id}")
        public Optional<Estacionamento> detalhar(@PathVariable Long id){
            Optional<Estacionamento> estacionamentoById = EstacionamentoRepository.findById(id);
            System.out.println(estacionamentoById);
            return estacionamentoById ;
        }
        @PutMapping("/{id}")
        @Transactional
        public ResponseEntity<Optional<Estacionamento>> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoEstacionamento form){
            Optional<Estacionamento> estacionamentoatt = form.atualizar(id, EstacionamentoRepository);
                return ResponseEntity.ok(estacionamentoatt);
        }
}


