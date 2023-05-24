package com.tlacuachesdevs.mydbms.BPTree;

/**
 *
 * @author mander
 */
public class MainBPTreeTest {

    public static void main(String[] args) {
        BPTree<Integer> bptree = new BPTree<>(3); // Crea un nuevo árbol B+ 

        // Insertar valores en el árbol
        //bptree.Insert(new Llave<>(10, "Valor 10"));
        //bptree.Insert(new Llave<>(20, "Valor 20"));
        //bptree.Insert(new Llave<>(5, "Valor 5"));
        //bptree.Insert(new Llave<>(15, "Valor 15"));
        //bptree.Insert(new Llave<>(25, "Valor 25"));
        //bptree.Insert(new Llave<>(12, "Valor 12"));
        //bptree.Insert(new Llave<>(30, "Valor 30")); 

        // Imprimir el árbol
        bptree.Show();
    }
}
