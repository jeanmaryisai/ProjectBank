//package com.company.config;
//
//import java.sql.DriverManager;
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Locale;
//import java.util.Objects;
//public abstract class  Connect {
//    public  abstract void iniatialize(){
//        Connection con = null;
//        try {
//            Class.forName("org.sqlite.JDBC");
//            con = DriverManager.getConnection("jdbc:sqlite:bank.db");
//            System.out.println("Opened database successfully");
//        } catch ( Exception e ) {
//            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
//            System.exit(0);
//    }
//    }
//
//}
