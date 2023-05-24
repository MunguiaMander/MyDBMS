package com.tlacuachesdevs.mydbms.managers;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author mander
 */
public class DataManager {

    public void setBetsText(JButton uploadXMLButton, JTextArea xmlJTextArea) {

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

}
