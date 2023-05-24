/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tlacuachesdevs.mydbms.BPTree;

/**
 *
 * @author mander
 * @param <Tipo>
 */
public class ArbolBP<Tipo> {

    private BPTNode<Tipo> raiz;
    private int alturaTotal;

    public BPTNode getRaiz() {
        return raiz;
    }

    public void setRaiz(BPTNode raiz) {
        this.raiz = raiz;
    }

}
