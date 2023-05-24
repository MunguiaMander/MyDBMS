package com.tlacuachesdevs.mydbms.table;

import java.util.*;
import javax.swing.JTextArea;

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

    public boolean containsColumn(String columnName) {
        for (Column column : columns) {
            if (column.getColumnName().equals(columnName)) {
                return true;
            }
        }
        return false;
    }

    public Column getColumn(String columnName) {
        for (Column column : columns) {
            if (column.getColumnName().equals(columnName)) {
                return column;
            }
        }
        return null;
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

    public void printTable(JTextArea databaseJTextArea) {
        databaseJTextArea.append("Table: " + tableName + "\n");

        // Print column names
        for (Column column : columns) {
            String columnName = column.getColumnName();
            if (column.getIsPK()) {
                columnName += " (PK)";
            }
            if (column.getIsFK()) {
                columnName += " (FK)";
            }
            databaseJTextArea.append(String.format("%-30s", columnName));
        }
        databaseJTextArea.append("\n");

        // Assume all columns have the same number of rows
        int numRows = columns.get(0).getData().size();

        for (int i = 0; i < numRows; i++) {
            for (Column column : columns) {
                databaseJTextArea.append(String.format("%-30s", column.getData().get(i)));
            }
            databaseJTextArea.append("\n");
        }
        databaseJTextArea.append("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
    }

}
