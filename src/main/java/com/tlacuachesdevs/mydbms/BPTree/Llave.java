package com.tlacuachesdevs.mydbms.BPTree;

/**
 *
 * @author mander
 */
public class Llave<Tipo> {

    public int llave;
    private Tipo valor;

    public Llave(int llave, Tipo valor) {
        this.llave = llave;
        this.valor = valor;
    }

    public Tipo getValor() {
        return valor;
    }

    public void setValor(Tipo valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return llave + ":" + valor;
    }
}
