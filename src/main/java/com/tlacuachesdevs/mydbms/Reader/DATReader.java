package com.tlacuachesdevs.mydbms.Reader;

/**
 *
 * @author mander
 */
import com.tlacuachesdevs.mydbms.table.*;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class DATReader {

    public void parseXML(String fileName, Tables tables) {
        try {
            String directoryPath = System.getProperty("user.dir");  // current dir
            File xmlFile = new File(directoryPath + File.separator + fileName);

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getDocumentElement().getChildNodes();

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    if (!tables.containsTable(element.getNodeName())) {
                        Table table = new Table(element.getNodeName());
                        tables.addTable(table);
                    }

                    Table table = tables.getTable(element.getNodeName());

                    NodeList childNodes = element.getChildNodes();
                    for (int j = 0; j < childNodes.getLength(); j++) {
                        Node cNode = childNodes.item(j);

                        if (cNode.getNodeType() == Node.ELEMENT_NODE) {
                            Element cElement = (Element) cNode;

                            if (!table.containsColumn(cElement.getNodeName())) {
                                Column<String> column = new Column<>(cElement.getNodeName());
                                table.addColumn(column);
                            }

                            Column<String> column = (Column<String>) table.getColumn(cElement.getNodeName());
                            column.addData(cElement.getTextContent());
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
