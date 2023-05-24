package com.tlacuachesdevs.mydbms.table;

import com.tlacuachesdevs.mydbms.util.LinkedList;
import javax.swing.JTextArea;

/**
 *
 * @author mander
 */
public class Tables {

    private LinkedList<Table> tables;

    public Tables() {
        tables = new LinkedList<>();
    }

    public void addTable(Table table) {
        tables.add(table);
    }

    public boolean containsTable(String tableName) {
        for (int i = 0; i < tables.size(); i++) {
            Table table = tables.get(i);
            if (table.getTableName().equals(tableName)) {
                return true;
            }
        }
        return false;
    }

    public Table getTable(String tableName) {
        for (int i = 0; i < tables.size(); i++) {
            Table table = tables.get(i);
            if (table.getTableName().equals(tableName)) {
                return table;
            }
        }
        return null;  // No table found with the given name.
    }

    public LinkedList<Table> getTables() {
        return tables;
    }

    public void printTables(JTextArea databaseJTextArea) {
        for (int i = 0; i < tables.size(); i++) {
            tables.get(i).printTable(databaseJTextArea);
            databaseJTextArea.append("\n");
        }
    }
}
