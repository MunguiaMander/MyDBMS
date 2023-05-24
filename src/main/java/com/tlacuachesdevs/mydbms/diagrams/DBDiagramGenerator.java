/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tlacuachesdevs.mydbms.diagrams;

/**
 *
 * @author mander
 */
import com.tlacuachesdevs.mydbms.table.*;
import guru.nidi.graphviz.attribute.Label;
import guru.nidi.graphviz.model.MutableGraph;
import guru.nidi.graphviz.model.MutableNode;
import guru.nidi.graphviz.engine.Format;
import guru.nidi.graphviz.engine.Graphviz;

import java.io.*;
import java.util.*;

import static guru.nidi.graphviz.model.Factory.*;

public class DBDiagramGenerator {

    private Tables tables;

    public DBDiagramGenerator(Tables tables) {
        this.tables = tables;
    }

    public void generateDiagram(String fileName) {
        MutableGraph g = mutGraph("dbDiagram").setDirected(true);
        Map<String, MutableNode> graphNodes = new HashMap<>();  // to store table nodes

        for (Table table : tables.getTables()) {
            MutableNode gTable = mutNode(table.getTableName());
            graphNodes.put(table.getTableName(), gTable);  // store the table node

            for (Column column : table.getColumns()) {
                String label = column.getColumnName() + (column.getIsPK() ? " (PK)" : "");
                if (column.getIsFK()) {
                    label += " (FK)";
                }
                String uniqueColumnName = table.getTableName() + "_" + column.getColumnName();  // Ensure unique column name
                MutableNode gColumn = mutNode(uniqueColumnName).add(Label.of(label));
                gTable.addLink(to(gColumn));
            }

            g.add(gTable);
        }

        // add FK links
        for (Table table : tables.getTables()) {
            for (Column column : table.getColumns()) {
                if (column.getIsFK()) {
                    MutableNode start = graphNodes.get(table.getTableName());
                    MutableNode end = graphNodes.get(column.getRefTable());
                    if (start != null && end != null) {
                        String linkLabel = column.getColumnName() + " -> " + column.getRefTable();
                        start.addLink(to(end).with(Label.of(linkLabel)));
                    }
                }
            }
        }

        try {
            Graphviz.fromGraph(g).width(3000).render(Format.PNG).toFile(new File(fileName));
        } catch (IOException e) {
            System.err.println("Error generating diagram: " + e.getMessage());
        }
    }

}
