/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tlacuachesdevs.mydbms.table;

import java.util.*;

public class Column<T> {

    private String columnName;
    private boolean isPK;
    private String refTable; //nombre de la tabla a la que hace referencia si es FK
    private boolean isFK;
    private List<T> data;

    public Column(String columnName) {
        this.columnName = columnName;
        this.data = new LinkedList<>();
    }

    //Getters
    public String getColumnName() {
        return columnName;
    }

    public List<T> getData() {
        return data;
    }

    public boolean getIsPK() {
        return isPK;
    }

    public boolean getIsFK() {
        return isFK;
    }

    public String getRefTable() {
        return refTable;
    }

    //Setters
    public void setIsPK(boolean isPK) {
        this.isPK = isPK;
    }

    public void setIsFK(boolean isFK) {
        this.isFK = isFK;
    }

    public void setRefTable(String refTable) {
        this.refTable = refTable;
    }

    public void addData(T data) {
        this.data.add(data);
    }
}
