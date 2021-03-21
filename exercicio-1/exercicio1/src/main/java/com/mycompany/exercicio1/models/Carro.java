/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exercicio1.models;

import java.util.ArrayList;


/**
 *
 * @author Matheus
 */
public class Carro {

    private String modelo;
    private double preco;
    private double motor;
    private String origem;

    public Carro() {
    }

    public Carro(String modelo, double preco, double motor, String origem) {
        this.modelo = modelo;
        this.preco = preco;
        this.motor = motor;
        this.origem = origem;
    }

    public double calculaIpi() {
        double ipi = 20;

        if (this.motor == 1.0) {
            ipi -= 10;
        }
        if ("Importado".equals(this.origem)) {
            ipi += 30;
        }

        return ipi;
    }

    public double calculaPrecoFinal(ArrayList<Double> adicionais) {
        
        double totalValorAdicionais = 0;
        
        if(!adicionais.isEmpty()){
            
            for (int i = 0; i < adicionais.size(); i++) {
                totalValorAdicionais += adicionais.get(i);
            }
        }
        
        double valorIpi = (this.preco + totalValorAdicionais) * (calculaIpi() / 100);
        
        return this.preco + totalValorAdicionais + valorIpi;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getMotor() {
        return motor;
    }

    public void setMotor(double motor) {
        this.motor = motor;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

}
