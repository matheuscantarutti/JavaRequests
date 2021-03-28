/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exercicio4.Models;

import java.util.ArrayList;

/**
 *
 * @author Matheus
 */
public class Urna {
    private ArrayList<Voto> votos;

    public Urna(ArrayList<Voto> votos) {
        this.votos = votos;
    }

    public Urna() {
    }

    public ArrayList<Voto> getVotos() {
        return votos;
    }

    public void setVotos(ArrayList<Voto> votos) {
        this.votos = votos;
    }
    
    public void addVoto(Voto v){
        this.votos.add(v);
    }
    
    public Boolean confereVoto(Voto v){
        Boolean votoValido = true;
        for(Voto computado : this.votos){
            if(computado.getEleitor().equals(v.getEleitor())){
                votoValido = false;
            }
        }
        return votoValido;
    }
}
