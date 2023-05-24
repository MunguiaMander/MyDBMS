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
public class Row<T> {

    private List<T> data;

    public Row() {
        data = new LinkedList<>();
    }

    public void addData(T data) {
        this.data.add(data);
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
