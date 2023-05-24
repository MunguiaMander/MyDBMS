package com.tlacuachesdevs.mydbms.Reader;

import com.tlacuachesdevs.mydbms.table.*;
import com.tlacuachesdevs.mydbms.util.LinkedList;
import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class XMLReader {

    public Tables parseXML(String fileName) {
        Tables tables = new Tables();

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(fileName));

            NodeList estructuras = document.getElementsByTagName("estructura");
            for (int i = 0; i < estructuras.getLength(); i++) {
                Node estructuraNode = estructuras.item(i);
                if (estructuraNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element estructuraElement = (Element) estructuraNode;
                    String tableName = estructuraElement.getElementsByTagName("tabla").item(0).getTextContent();

                    Table table = new Table(tableName);

                    NodeList childNodes = estructuraElement.getChildNodes();
                    for (int j = 0; j < childNodes.getLength(); j++) {
                        Node childNode = childNodes.item(j);
                        if (childNode.getNodeType() == Node.ELEMENT_NODE) {
                            String nodeName = childNode.getNodeName();

                            if (!nodeName.equals("tabla") && !nodeName.equals("clave") && !nodeName.equals("relacion")) {
                                String columnName = nodeName;  // get the node name as column name
                                Column column = new Column(columnName);
                                table.addColumn(column);

                                // Check if it is Primary Key
                                if (columnName.equals(estructuraElement.getElementsByTagName("clave").item(0).getTextContent())) {
                                    table.markColumnAsPK(columnName);
                                }
                            }

                            if (nodeName.equals("relacion")) {
                                Element relacionElement = (Element) childNode;
                                NodeList relacionChildNodes = relacionElement.getChildNodes();

                                String fkColumnName = null;
                                String refTableName = null;

                                for (int k = 0; k < relacionChildNodes.getLength(); k++) {
                                    Node relacionChildNode = relacionChildNodes.item(k);
                                    if (relacionChildNode.getNodeType() == Node.ELEMENT_NODE) {
                                        if (fkColumnName == null) {
                                            fkColumnName = relacionChildNode.getNodeName();
                                        } else if (refTableName == null) {
                                            refTableName = relacionChildNode.getTextContent();
                                        }
                                    }
                                }

                                if (fkColumnName != null && refTableName != null) {
                                    table.markColumnAsFK(fkColumnName, refTableName);
                                }
                            }
                        }
                    }
                    tables.addTable(table);
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            ex.printStackTrace();
        }

        return tables;
    }

}
