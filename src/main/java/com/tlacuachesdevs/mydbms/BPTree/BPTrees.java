package com.tlacuachesdevs.mydbms.BPTree;

/**
 *
 * @author mander
 */
import com.tlacuachesdevs.mydbms.table.*;
import com.tlacuachesdevs.mydbms.util.*;
import java.util.*;

public class BPTrees {

    private DoublyLinkedList<TableBPTreePair> trees;

    public BPTrees() {
        trees = new DoublyLinkedList<>();
    }

    public void generateBPTrees(Tables tables) {
        for (Table table : tables.getTables()) {
            createBPTreeForTable(table);
        }
    }

    public BPTree<Object> getBPTreeForTable(String tableName) {
        Node<TableBPTreePair> node = trees.search(new TableBPTreePair(tableName, null));
        if (node != null) {
            return node.getData().getBPTree();
        }
        return null;
    }

    private void createBPTreeForTable(Table table) {
        for (Column column : table.getColumns()) {
            if (column.getIsPK()) {
                BPTree<Object> bptree = new BPTree<>(3);
                for (Object data : column.getData()) {
                    if (data instanceof String) {
                        try {
                            int value = Integer.parseInt((String) data);
                            bptree.Insert(new Llave<>(value, "Valor " + data));
                        } catch (NumberFormatException e) {
                        }
                    } else if (data instanceof Integer) {
                        bptree.Insert(new Llave<>((Integer) data, "Valor " + data));
                    } else {
                    }
                }
                trees.insert(new TableBPTreePair(table.getTableName(), bptree));
                break;
            }
        }
    }

    private class TableBPTreePair {

        private String tableName;
        private BPTree<Object> bptree;

        public TableBPTreePair(String tableName, BPTree<Object> bptree) {
            this.tableName = tableName;
            this.bptree = bptree;
        }

        public String getTableName() {
            return tableName;
        }

        public BPTree<Object> getBPTree() {
            return bptree;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            TableBPTreePair that = (TableBPTreePair) obj;
            return Objects.equals(tableName, that.tableName);
        }

        @Override
        public int hashCode() {
            return Objects.hash(tableName);
        }
    }
}
