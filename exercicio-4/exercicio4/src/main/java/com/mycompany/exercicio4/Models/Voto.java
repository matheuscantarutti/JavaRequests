/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exercicio4.Models;

/**
 *
 * @author Matheus
 */
public class Voto {
    private String eleitor;
    private String candidato;

    public Voto(String eleitor, String candidato) {
        this.eleitor = eleitor;
        this.candidato = candidato;
    }

    public Voto() {
    }

    public String getEleitor() {
        return eleitor;
    }

    public void setEleitor(String eleitor) {
        this.eleitor = eleitor;
    }

    public String getCandidato() {
        return candidato;
    }

    public void setCandidato(String candidato) {
        this.candidato = candidato;
    }
    
    
}
