/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exercicio3.Models;

/**
 *
 * @author Matheus
 */
public class Pessoa {
    private String cpf;
    private String sexo;
    private String corCabelo;
    private String corOlhos;
    private int idade;
    private int altura;

    public Pessoa() {
    }

    public Pessoa(String cpf, String sexo, String corCabelo, String corOlhos, int idade, int altura) {
        this.cpf = cpf;
        this.sexo = sexo;
        this.corCabelo = corCabelo;
        this.corOlhos = corOlhos;
        this.idade = idade;
        this.altura = altura;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCorCabelo() {
        return corCabelo;
    }

    public void setCorCabelo(String corCabelo) {
        this.corCabelo = corCabelo;
    }

    public String getCorOlhos() {
        return corOlhos;
    }

    public void setCorOlhos(String corOlhos) {
        this.corOlhos = corOlhos;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
    
    
}
