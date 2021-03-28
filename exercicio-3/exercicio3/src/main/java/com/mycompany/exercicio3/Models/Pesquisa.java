/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exercicio3.Models;

import java.util.List;

/**
 *
 * @author Matheus
 */
public class Pesquisa {
    private List<Pessoa> entrevistados;

    public Pesquisa() {
    }

    public Pesquisa(List<Pessoa> entrevistados) {
        this.entrevistados = entrevistados;
    }

    public List<Pessoa> getEntrevistados() {
        return entrevistados;
    }

    public void setEntrevistados(List<Pessoa> entrevistados) {
        this.entrevistados = entrevistados;
    }
    
    public void addEntrevistado(Pessoa p){
        this.entrevistados.add(p);
    }
    
    public int maiorAltura(){
        int maior = this.entrevistados.get(0).getAltura();
        for (Pessoa entrevistado : this.entrevistados) {
            
            if(entrevistado.getAltura() > maior){
                maior = entrevistado.getAltura();
            }
        }
        return maior;
    }
    
    public int menorAltura(){
        int menor = this.entrevistados.get(0).getAltura();
        for (Pessoa entrevistado : this.entrevistados) {
            
            if(entrevistado.getAltura() < menor){
                menor = entrevistado.getAltura();
            }
        }
        return menor;
    }
    
    public int mediaAlturaFeminina(){
        int sum = 0;
        
        for (Pessoa entrevistado : this.entrevistados) {
            if(entrevistado.getSexo().equals("Feminino")){
                sum += entrevistado.getAltura();
            }
        }
        return sum / qtdFeminino();
    }
    
    public int qtdMasculino(){
        int qtd = 0;
        for(Pessoa entrevistado : this.entrevistados){
            if(entrevistado.getSexo().equals("Masculino")){
                qtd ++;
            }
        }
        return qtd;
    }
    
    public int qtdFeminino(){
        int qtd = 0;
        for(Pessoa entrevistado : this.entrevistados){
            if(entrevistado.getSexo().equals("Feminino")){
                qtd ++;
            }
        }
        return qtd;
    }
    
    public String percentualMasculino(){
        int qtdMas = qtdMasculino();
        int percent = (qtdMas * 100) / this.entrevistados.size();
        
        return percent+"%";
    }
    
    public String percentualFeminino(){
        int qtdFem = qtdFeminino();
        int percent = (qtdFem * 100) / this.entrevistados.size();
        
        return percent+"%";
    }
    
    public String adultasEscandinavas(){
        int qtd = 0;
        
        for(Pessoa entrevistada : this.entrevistados){
            if(entrevistada.getSexo().equals("Feminino") && 
               entrevistada.getIdade() >= 18 &&
               entrevistada.getIdade() <= 35 &&
               entrevistada.getCorOlhos().equals("Verdes") &&
               entrevistada.getCorCabelo().equals("Loiro")){
                    qtd++;
            }
        }
        return (qtd * 100) / qtdFeminino() + "%";
    }
    
    
    
}
