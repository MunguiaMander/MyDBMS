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
