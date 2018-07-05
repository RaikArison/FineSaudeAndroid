package com.example.arisonraik.finesaude;

import java.io.Serializable;

public class UsuarioAPI implements Serializable {

    private String id;
    private String nome;
    private String sobreNome;
    private String cpf;
    private String contato;
    private String idade;
    private String peso;
    private String altura;
    private String email;

    public UsuarioAPI() { }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public String setNome(String nome) {
        this.nome = nome;
        return nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public String getCpf() {
        return cpf;
    }

    public String setCpf(String cpf) {
        this.cpf = cpf;
        return cpf;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getIdade() {
        return idade;
    }

    public String setIdade(String idade) {
        this.idade = idade;
        return idade;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return
                "Nome= " + nome + '\n' +
                        "Idade= " + idade + '\n' +
                        "Peso= " + peso + '\n' +
                        "Altura= " + altura + '\n';
    }
}