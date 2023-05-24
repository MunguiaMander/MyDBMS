/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tlacuachesdevs.mydbms.BPTree;

/**
 *
 * @author mander
 */
public class BPTNode<Tipo> {

    public int n;
    public Llave<Tipo> key[];
    public BPTNode<Tipo> child[];
    public boolean leaf = true;

    public BPTNode<Tipo> left;
    public BPTNode<Tipo> right;

    public BPTNode(int T) {
        this.key = new Llave[2 * T - 1];
        this.child = new BPTNode[2 * T];
    }

    public int Find(int k) {
        for (int i = 0; i < this.n; i++) {
            if (this.key[i].llave == k) {
                return i;
            }
        }
        return -1;
    }
}
