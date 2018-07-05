package com.example.arisonraik.finesaude;

import java.io.Serializable;

class Medidas implements Serializable {

    private String id;
    private String fkUsuario;
    private String peso;
    private String altura;
    private String circunferencia;
    private String data;

    public Medidas() { }

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

    public String getPeso() {
        return peso;
    }

    public String setPeso(String peso) {
        this.peso = peso;
        return peso;
    }

    public String getAltura() {
        return altura;
    }

    public String setAltura(String altura) {
        this.altura = altura;
        return altura;
    }

    public String getCircunferencia() {
        return circunferencia;
    }

    public String setCircunferencia(String circunferencia) {
        this.circunferencia = circunferencia;
        return circunferencia;
    }

    public String getData() {
        return data;
    }

    public String setData(String data) {
        this.data = data;
        return data;
    }

    @Override
    public String toString() {
        return
                "Peso= " + peso + '\n' +
                        "Altura= " + altura + '\n';
    }
}
