/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tlacuachesdevs.mydbms.table;

import com.tlacuachesdevs.mydbms.util.LinkedList;

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

    public void printTables() {
        for (int i = 0; i < tables.size(); i++) {
            tables.get(i).printTable();
            System.out.println();
        }
    }
}
