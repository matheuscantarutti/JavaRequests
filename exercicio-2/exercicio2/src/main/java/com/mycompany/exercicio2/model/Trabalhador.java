/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exercicio2.model;

/**
 *
 * @author Matheus
 */
public class Trabalhador {
    private String nome;
    private int idade;
    private int tempoTrabalho;

    public Trabalhador() {
    }

    public Trabalhador(String nome, int idade, int tempoTrabalho) {
        this.nome = nome;
        this.idade = idade;
        this.tempoTrabalho = tempoTrabalho;
    }

    
    public String calculaAposentadoria(){
        if(this.idade >= 65 || 
           this.tempoTrabalho >= 30 || 
          (this.idade >= 60 && this.tempoTrabalho >= 25)){
            return "Requerer Aposentadoria";
        }
        
        return "Não requerer";
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getTempoTrabalho() {
        return tempoTrabalho;
    }

    public void setTempoTrabalho(int tempoTrabalho) {
        this.tempoTrabalho = tempoTrabalho;
    }
    
    
}
