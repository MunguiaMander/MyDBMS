package com.tlacuachesdevs.mydbms.managers;

import com.tlacuachesdevs.mydbms.BPTree.BPTree;
import com.tlacuachesdevs.mydbms.BPTree.BPTrees;
import com.tlacuachesdevs.mydbms.Reader.*;
import com.tlacuachesdevs.mydbms.diagrams.DBDiagramGenerator;
import com.tlacuachesdevs.mydbms.table.Table;
import com.tlacuachesdevs.mydbms.table.Tables;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author mander
 */
public class DataManager {

    private Tables tables;

    public void setTables(Tables tables) {
        this.tables = tables;
    }

    public void setXMLText(JButton uploadXMLButton, JTextArea xmlJTextArea) {

        uploadXMLButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                JFileChooser chooseData = new JFileChooser();
                chooseData.showOpenDialog(null);
                File data = chooseData.getSelectedFile();
                try {
                    FileReader readData = new FileReader(data);
                    BufferedReader br = new BufferedReader(readData);
                    String text = "";
                    String line = "";
                    while ((line = br.readLine()) != null) {
                        text += line + "\n";
                    }
                    xmlJTextArea.setText(text);
                    JOptionPane.showMessageDialog(null, "The file has been read");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error while tryng read the file");
                }

            }
        });
    }

    public void setER(JButton uploadImageButton, JScrollPane imageViewerScrollPane) {

        uploadImageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    ImageIcon imageIcon = new ImageIcon(selectedFile.getAbsolutePath());
                    JLabel imageViewerLabel = new JLabel();
                    imageViewerLabel.setIcon(imageIcon);
                    imageViewerLabel.setText(""); // Delete any text un the label

                    imageViewerScrollPane.setViewportView(imageViewerLabel);
                    imageViewerScrollPane.setPreferredSize(new Dimension(imageIcon.getIconWidth(), imageIcon.getIconHeight()));
                } else {
                    JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna imagen");
                }
            }
        });
    }

    public void setDBMS(JButton loginButton, JFrame DBMSJFrame, JFrame loginFrame) {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                // Create and config new Frame
                JFrame newFrame = new JFrame("DBMS");
                // Close actual JFrame
                loginFrame.dispose();
                // Show next JFrame
                DBMSJFrame.setVisible(true);
            }
        });
    }

    public void readTables(JButton sendTablesButton) {
        sendTablesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                XMLReader xmlReader = new XMLReader();
                DataManager.this.tables = xmlReader.parseXML("estructuras.xml");
                DBDiagramGenerator diagramGenerator = new DBDiagramGenerator(DataManager.this.tables);
                //Creating diagrama ER
                diagramGenerator.generateDiagram("dbDiagram.png");
            }
        });
    }

    public void showTables(JButton viewDBButton, final JTextArea databaseJTextArea) {
        viewDBButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Clear JTextArea
                databaseJTextArea.setText("");
                DataManager.this.tables.printTables(databaseJTextArea);
            }
        });
    }

    public void sendRecords(JButton sendRecordsButton) {
        sendRecordsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DATReader datReader = new DATReader();
                datReader.parseXML("entrada.dat", DataManager.this.tables);
            }
        });
    }

    public void showBPTrees(JButton viewBPTreesButton, JTextArea bptJTextArea, final JTextArea databaseJTextArea) {
        viewBPTreesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BPTrees bptrees = new BPTrees();
                bptrees.generateBPTrees(DataManager.this.tables);
                for (Table table : DataManager.this.tables.getTables()) {
                    BPTree<Object> bpt = bptrees.getBPTreeForTable(table.getTableName());
                    if (bpt != null) {
                        bptJTextArea.append("Table: " + table.getTableName() + "\n");
                        bpt.Show(bptJTextArea);
                        bptJTextArea.append("- - - - - - - - - - - - - - -\n");
                        System.out.println("Table: " + table.getTableName() + "\n");
                        bpt.ShowConsole();
                        System.out.println("- - - - - - - - - - - - - - -\n");
                    }
                }
            }
        });
    }

}
