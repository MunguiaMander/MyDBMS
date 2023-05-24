package com.tlacuachesdevs.mydbms.Reader;

/**
 *
 * @author mander
 */
import com.tlacuachesdevs.mydbms.diagrams.*;
import com.tlacuachesdevs.mydbms.table.*;
import com.tlacuachesdevs.mydbms.util.*;

public class Main {

    public static void main(String[] args) {

        // Crear el lector XML
        XMLReader xmlReader = new XMLReader();

        // Leer las tablas desde el archivo XML
        Tables tables = xmlReader.parseXML("estructuras.xml");

        // Imprimir todas las tablas
        tables.printTables();

        DBDiagramGenerator diagramGenerator = new DBDiagramGenerator(tables);
        diagramGenerator.generateDiagram("dbDiagram.png");

    }
}
