package br.com.estacionamento.config;

public class ErroEstacionamento {

    private String campo;
    private String erro;

    public ErroEstacionamento(String campo, String erro) {
        this.campo = campo;
        this.erro = erro;
    }

    public String getCampo() {
        return campo;
    }

    public String getErro() {
        return erro;
    }
}
