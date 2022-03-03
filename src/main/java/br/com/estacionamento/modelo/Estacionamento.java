package br.com.estacionamento.modelo;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Estacionamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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

    public Estacionamento() {
    }

    public Estacionamento(Long id, String cnpj, String endereco, String telefone, int quantidadeCarros, int quantidadeMotos, String nome) {

        this.id = id;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.telefone = telefone;
        this.quantidadeCarros = quantidadeCarros;
        this.quantidadeMotos = quantidadeMotos;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getendereco() {
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
}
