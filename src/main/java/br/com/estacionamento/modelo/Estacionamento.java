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

    public static void setCnpj(String cnpj) {
        cnpj = cnpj;
    }

    public String getendereco() {
        return endereco;
    }

    public static void setEndereco(String endereco) {
        endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public static void setTelefone(String telefone) {
        telefone = telefone;
    }

    public int getQuantidadeCarros() {
        return quantidadeCarros;
    }

    public static void setQuantidadeCarros(int quantidadeCarros) {
        quantidadeCarros = quantidadeCarros;
    }

    public int getQuantidadeMotos() {
        return quantidadeMotos;
    }

    public static void setQuantidadeMotos(int quantidadeMotos) {quantidadeMotos = quantidadeMotos;
    }

    public String getNome() {
        return nome;
    }

    public static void setNome(String nome) {
        nome = nome;
    }
}
