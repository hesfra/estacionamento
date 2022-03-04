package br.com.estacionamento.form;

import br.com.estacionamento.modelo.Estacionamento;
import br.com.estacionamento.repository.EstacionamentoRepository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Optional;

public class AtualizacaoEstacionamento {

    @NotNull
    @NotEmpty
    private String cnpj;
    @NotNull @NotEmpty
    private String endereco;
    @NotNull    @NotEmpty
    private String telefone;
    @NotNull
    private int quantidadeCarros;
    @NotNull
    private int quantidadeMotos;
    @NotNull    @NotEmpty
    private String nome;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getQuantidadeCarros() {
        return quantidadeCarros;
    }

    public void setQuantidadeCarros(int quantidadeCarros) {
        this.quantidadeCarros = quantidadeCarros;
    }

    public int getQuantidadeMotos() {
        return quantidadeMotos;
    }

    public void setQuantidadeMotos(int quantidadeMotos) {
        this.quantidadeMotos = quantidadeMotos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Optional<Estacionamento> atualizar(Long id, EstacionamentoRepository estacionamentoRepository) {
        Optional<Estacionamento> estacionamento = estacionamentoRepository.findById(id);

        Estacionamento.setCnpj(this.cnpj);
        Estacionamento.setEndereco(this.endereco);
        Estacionamento.setTelefone(this.telefone);
        Estacionamento.setQuantidadeCarros(this.quantidadeCarros);
        Estacionamento.setQuantidadeMotos(this.quantidadeMotos);
        Estacionamento.setNome(this.nome);

        return estacionamento;
    }
}
