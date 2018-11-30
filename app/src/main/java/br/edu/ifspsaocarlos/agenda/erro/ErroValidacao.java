package br.edu.ifspsaocarlos.agenda.erro;

public class ErroValidacao {

    private String mensagem;

    public ErroValidacao(String mensagem){
        this.mensagem = mensagem;
    }

    public String getMensagem(){
        return this.mensagem;
    }

}