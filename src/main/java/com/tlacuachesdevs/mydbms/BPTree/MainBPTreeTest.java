package com.tlacuachesdevs.mydbms.BPTree;

/**
 *
 * @author mander
 */
public class MainBPTreeTest {

    public static void main(String[] args) {
        int grade = 3;
        BPTree<Integer> bptree = new BPTree<>(grade); // Create a new B+ tree 

        // Insert data into B+
        bptree.Insert(new Llave<>(10, "Valor 10"));
        bptree.Insert(new Llave<>(20, "Valor 20"));
        bptree.Insert(new Llave<>(5, "Valor 5"));
        bptree.Insert(new Llave<>(15, "Valor 15"));
        bptree.Insert(new Llave<>(25, "Valor 25"));
        bptree.Insert(new Llave<>(12, "Valor 12"));
        bptree.Insert(new Llave<>(30, "Valor 30")); 
        bptree.Insert(new Llave<>(33, "Valor 33")); 

        // Show B+ in console
        bptree.ShowConsole();
    }
}
