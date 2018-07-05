package com.example.arisonraik.finesaude;

import java.io.Serializable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class HistoricoAlergico implements Serializable {

    private String id;
    private String fkUsuario;
    private String fkAlimento;
    private String dtOcorrido;
    private String dtInsercao;
    private String descricao;
    private String tipoReacao;

    public HistoricoAlergico() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFkUsuario() {
        return fkUsuario;
    }

    public void setFkUsuario(String fkUsuario) {
        this.fkUsuario = fkUsuario;
    }

    public String getFkAlimento() {
        return fkAlimento;
    }

    public String setFkAlimento(String fkAlimento) {
        this.fkAlimento = fkAlimento;
        return fkAlimento;
    }

    public String getDtOcorrido() {
        return dtOcorrido;
    }

    public String setDtOcorrido(String dtOcorrido) {
        this.dtOcorrido = dtOcorrido;
        return dtOcorrido;
    }

    public String getDtInsercao() {
        return dtInsercao;
    }

    public String setDtInsercao(String dtInsercao) {
        this.dtInsercao = dtInsercao;
        return dtInsercao;
    }

    public String getDescricao() {
        return descricao;
    }

    public String setDescricao(String descricao) {
        this.descricao = descricao;
        return descricao;
    }

    public String getTipoReacao() {
        return tipoReacao;
    }

    public String setTipoReacao(String tipoReacao) {
        this.tipoReacao = tipoReacao;
        return tipoReacao;
    }

    @Override
    public String toString() {
        return
                "id= " + id + '\n' +
                        "fkUsuario= " + fkUsuario + '\n' +
                        "fkAlimento= " + fkAlimento + '\n' +
                        "dataOcorrido= " + dtOcorrido + '\n' +
                        "dataInsercao= " + dtInsercao + '\n' +
                        "descricao= " + descricao + '\n' +
                        "tipoReacao= " + tipoReacao + '\n';
    }

}
