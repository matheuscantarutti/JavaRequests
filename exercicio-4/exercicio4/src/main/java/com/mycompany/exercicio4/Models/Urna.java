/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exercicio4.Models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    
    public void addVoto(Voto vt){
        this.votos.add(vt);
    }
    
    public int confereVoto(String eleitor){
        int votoValido = 1;
        for(Voto computado : this.votos){
            if(computado.getEleitor().toLowerCase().equals(eleitor.toLowerCase())){
                votoValido = 0;
            }
        }
        return votoValido;
    }
    
    public ArrayList<String> contaVotos(){
       Map<String, Integer> hm = new HashMap<>();
  
        for (Voto vt : this.votos) {
            Integer j = hm.get(vt.getCandidato());
            hm.put(vt.getCandidato(), (j == null) ? 1 : j + 1);
        }
        
        ArrayList<String> resultado = new ArrayList<>();
        
        int maiorValor = 0;
        String vencedor = "";
        for (Map.Entry<String, Integer> val : hm.entrySet()) {
            for (Map.Entry<String, Integer> valor : hm.entrySet()){
                if(valor.getValue() > maiorValor){
                    maiorValor = valor.getValue();
                    vencedor = val.getKey();
                }
            }
            
            int percent = (val.getValue() * 100) / this.votos.size();
            resultado.add(val.getKey()+" - "+percent+"%");
        }
        int percenteVencedor = (maiorValor * 100) / this.votos.size();
        resultado.add("VENCEDOR- "+vencedor+" - "+percenteVencedor+"%");
        
        return resultado;
    }
}
