package br.edu.ifspsaocarlos.agenda.activity;

import br.edu.ifspsaocarlos.agenda.erro.ErroValidacao;

public class ErroValidacaoCampo extends ErroValidacao {

    private int idCampo;

    public ErroValidacaoCampo(String mensagem, int idCampo){
        super(mensagem);
        this.idCampo = idCampo;
    }

    public int getCampo(){
        return idCampo;
    }

}
