package com.company;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class Sqlcon {
    public static void createDatabase(){
        Connection con = null;
        Statement stmt = null;

        try {

            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:bank.db");
            System.out.println("Opened database successfully");

            stmt = con.createStatement();
            String sql = "CREATE TABLE CLIENT " +
                    "(ID INT PRIMARY KEY     NOT NULL," +
                    " NOM            TEXT    NOT NULL, " +
                    " CIN_or_NIF     INT     NOT NULL, " +
                    " NUM_COMPTE     INT     NOT NULL, " +
                    " TYPE_COMPTE    TEXT     NOT NULL, " +
                    " TYPE_CLIENT    TEXT     NOT NULL, " +
                    "     TEXT     NOT NULL, " +
                    " ADDRESSE       CHAR(50), " +
                    " SEXE           TEXT)";
            stmt.executeUpdate(sql);
            stmt.close();
            con.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Table created successfully");
    }
    public static void insertValue(List<Object> list, String tabName){
        Connection c = null;
        Statement stmt = null;
        tabName= tabName.toUpperCase();
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");
            Statement s = c.createStatement();
            if(Objects.equals(tabName,"CLIENT")){
                s.executeUpdate("INSERT INTO '"+tabName+"'(NOM,CIN_or_NIF,NUM_COMPTE,TYPE_COMPTE, TYPE_CLIENT, ADDRESSE, SEXE) VALUE ()");
            }else if(Objects.equals(tabName,"Compte")){
                s.executeUpdate("INSERT INTO '"+tabName+"'(NOM,CIN_or_NIF,NUM_COMPTE,TYPE_COMPTE, TYPE_CLIENT, ADDRESSE, SEXE) VALUE ()");
            }else if(Objects.equals(tabName,"TRANSFERT")){
                s.executeUpdate("INSERT INTO '"+tabName+"'(NOM,CIN_or_NIF,NUM_COMPTE,TYPE_COMPTE, TYPE_CLIENT, ADDRESSE, SEXE) VALUE ()");
            }else if(Objects.equals(tabName,"TRANSACTION")) {
                s.executeUpdate("INSERT INTO '" + tabName + "'(NOM,CIN_or_NIF,NUM_COMPTE,TYPE_COMPTE, TYPE_CLIENT, ADDRESSE, SEXE) VALUE ()");
            }
            s.close();
            c.commit();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Records created successfully");
    }

    public static List<Object> loadData(){
        Connection con = null;
        Statement stmt = null;
        int i=0;
        List<Object> listData= new ArrayList<Object>();
        try {

            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:bank.db");
            System.out.println("Opened database successfully");

            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM CLIENT;" );

            while ( rs.next() ) {
                int id = rs.getInt("id");
                listData.add(i,id);
                String  name = rs.getString("name");
                int age  = rs.getInt("age");
                String  address = rs.getString("address");
                float salary = rs.getFloat("salary");

                i++;
            }
            stmt.close();
            con.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Table created successfully");
        return listData;
    }

}


