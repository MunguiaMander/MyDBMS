/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tlacuachesdevs.mydbms.table;

import java.util.*;

/**
 *
 * @author mander
 */
public class Table {

    private String tableName;
    private List<Column> columns;

    public Table(String tableName) {
        this.tableName = tableName;
        this.columns = new LinkedList<>();
    }

    public String getTableName() {
        return tableName;
    }

    public List<Column> getColumns() {
        return columns;
    }

    public void addColumn(Column column) {
        this.columns.add(column);
    }

    public void markColumnAsPK(String columnName) {
        for (Column column : columns) {
            if (column.getColumnName().equals(columnName)) {
                column.setIsPK(true);
            }
        }
    }

    public void markColumnAsFK(String columnName, String refTable) {
        for (Column column : columns) {
            if (column.getColumnName().equals(columnName)) {
                column.setIsFK(true);
                column.setRefTable(refTable);
            }
        }
    }

    public void printTable() {
        System.out.println("Table: " + tableName);

        // Print column names
        for (Column column : columns) {
            System.out.print(column.getColumnName());
            if (column.getIsPK()) {
                System.out.print(" (PK)");
            }
            if (column.getIsFK()) {
                System.out.print(" (FK)");
            }
            System.out.print("\t");
        }
        System.out.println();

        // Assume all columns have the same number of rows
        int numRows = columns.get(0).getData().size();

        for (int i = 0; i < numRows; i++) {
            for (Column column : columns) {
                System.out.print(column.getData().get(i) + "\t");
            }
            System.out.println();
        }
    }

}
