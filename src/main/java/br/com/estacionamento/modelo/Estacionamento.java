package br.com.estacionamento.modelo;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
public class Estacionamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String CNPJ;
    @NotNull
    private String Endereço;
    @NotNull
    private String Telefone;
    @NotNull
    private int QuantidadeCarros;
    @NotNull
    private int QuantidadeMotos;
    @NotNull
    private String Nome;

    public Estacionamento() {
    }

    public Estacionamento(Estacionamento estacionamento) {

    }

    public Estacionamento(Long id, String CNPJ, String endereço, String telefone, int quantidadeCarros, int quantidadeMotos, String nome) {
        this.id = id;
        this.CNPJ = CNPJ;
        this.Endereço = endereço;
        this.Telefone = telefone;
        this.QuantidadeCarros = quantidadeCarros;
        this.QuantidadeMotos = quantidadeMotos;
        this.Nome = nome;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getEndereço() {
        return Endereço;
    }

    public void setEndereço(String endereço) {
        this.Endereço = endereço;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String telefone) {
        this.Telefone = telefone;
    }

    public int getQuantidadeCarros() {
        return QuantidadeCarros;
    }

    public void setQuantidadeCarros(int quantidadeCarros) {
        this.QuantidadeCarros = quantidadeCarros;
    }

    public int getQuantidadeMotos() {
        return QuantidadeMotos;
    }

    public void setQuantidadeMotos(int quantidadeMotos) {
        this.QuantidadeMotos = quantidadeMotos;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        this.Nome = nome;
    }
}
