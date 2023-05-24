/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.tlacuachesdevs.mydbms.table;

/**
 *
 * @author mander
 */
public class TableTest {

    public static void main(String[] args) {
        Table personTable = new Table("Person");
        Column idColumn = new Column("ID");
        personTable.addColumn(idColumn);
        Column nameColumn = new Column("Name");
        personTable.addColumn(nameColumn);
        Column emailColumn = new Column("EMAIL");
        personTable.addColumn(emailColumn);
        Column phoneColumn = new Column("Phone");
        personTable.addColumn(phoneColumn);

        idColumn.addData(1);
        nameColumn.addData("Marco Jose");
        emailColumn.addData("marcojose@example.com");
        phoneColumn.addData(1234567890);

        idColumn.addData(2);
        nameColumn.addData("Juan Diego");
        emailColumn.addData("juandiego@example.com");
        phoneColumn.addData(987654321);

        // Mark ID column as primary key
        personTable.markColumnAsPK("ID");

        // Print the table
        personTable.printTable();
    }
}
