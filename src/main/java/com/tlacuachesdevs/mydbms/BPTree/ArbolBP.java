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
