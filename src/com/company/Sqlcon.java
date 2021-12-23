package com.company;


import java.sql.*;
import java.sql.Date;
import java.util.*;

public class Sqlcon {

    private static Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:bank.db";

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public static void createDatabase(String tabName) {
        Connection con = null;
        Statement stmt = null;
        tabName = tabName.toUpperCase();
        boolean test = true;
        try {

            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:bank.db");
            System.out.println("Opened database successfully");
            stmt = con.createStatement();
            //verify if tab exist in database
            String sqltes = "IF OBJECT_ID(N'bank.Customers', N'U') IS NOT NULL" +
                    "BEGIN" +
                    "    PRINT 'Table Exists'\n" +
                    "END";
            // create tab
            if (Objects.equals(tabName, "CLIENT")) {
                String sql = "CREATE TABLE '" + tabName + "' " +
                        " (CIN_or_NIF    INT PRIMARY KEY   NOT NULL ," +
                        " TYPE_CLIENT    TEXT     NOT NULL, " +
                        " NOM_COMPLET    TEXT    NOT NULL, " +
                        " SEXE           INT     NOT NULL, " +
                        " ADDRESSE       CHAR(50) NOT NULL, " +
                        " TEL            INT   NOT NULL)";
                stmt.executeUpdate(sql);
            } else if (Objects.equals(tabName, "COMPTE")) {
                String sql = "CREATE TABLE '" + tabName + "' " +
                        " (NUMERO_UNIQ    INT PRIMARY KEY    NOT NULL, " +
                        " TYPE_COMPTE    TEXT    NOT NULL, " +
                        " SOLDE     INT     NOT NULL, " +
                        " ETAT       CHAR(50) NOT NULL, " +
                        " OWNER       TEXT   NOT NULL," +
                        " CONSTRAINT CLIENT " +
                        " FOREIGN KEY (OWNER) " +
                        " REFERENCES CLIENT(CIN_or_NIF)) ";

                stmt.executeUpdate(sql);
            } else if (Objects.equals(tabName, "TRANSFERT")) {
                String sql = "CREATE TABLE '" + tabName + "' " +
                        "(ID INT PRIMARY KEY     NOT NULL," +
                        " NUMERO_DEBITEUR    INT     NOT NULL, " +
                        " NUMERO_CREDITEUR    INT    NOT NULL, " +
                        " DATE    TEXT    NOT NULL, " +
                        " DESCRIPTION     TEXT     NOT NULL, " +
                        " MONTANTDEPOSE       INT NOT NULL, " +
                        " MONTANTRETIRE       INT   NOT NULL)";

                stmt.executeUpdate(sql);
            } else if (Objects.equals(tabName, "TRANSACTION")) {
                String sql = "CREATE TABLE '" + tabName + "' " +
                        "(ID INT PRIMARY KEY     NOT NULL," +
                        " ISDEPOT    TEXT  NOT NULL, " +
                        " NUMERO_COMPTE    INT    NOT NULL, " +
                        " MONTANT    INT    NOT NULL, " +
                        " DATE    DATE   NOT NULL) ";
                stmt.executeUpdate(sql);

            }
            stmt.close();
            con.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Table created successfully");
    }

    public static void save(String tabName, ListField listField) {

        Connection c = null;
        Statement stmt = null;
        System.out.println("start saving");
        tabName = tabName.toUpperCase();

        if (Objects.equals(tabName, "CLIENT")) {
            String sql = "INSERT INTO '" + tabName + "' (CIN_or_NIF,TYPE_CLIENT,NOM_COMPLET, SEXE,ADDRESSE,TEL) VALUES(?,?,?,?,?,?)";
            try (Connection conn = connect();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, (Integer) listField.getChamp1());
                pstmt.setString(2, (String) listField.getChamp2());
                pstmt.setString(3, (String) listField.getChamp3());
                pstmt.setString(4, (String) listField.getChamp4());
                pstmt.setString(5, (String) listField.getChamp5());
                pstmt.setInt(6, (Integer) listField.getChamp6());
                pstmt.executeUpdate();
                System.out.println("save");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        } else if (Objects.equals(tabName, "COMPTE")) {

            String sql = "INSERT INTO '" + tabName + "' (NUMERO_UNIQ,TYPE_COMPTE,SOLDE, ETAT,OWNER) VALUES(?,?,?,?,?)";
            try (Connection conn = connect();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, (Integer) listField.getChamp1());
                pstmt.setBoolean(2, (Boolean) listField.getChamp2());
                pstmt.setDouble(3, (Double) listField.getChamp3());
                pstmt.setString(4, (String) listField.getChamp4());
                pstmt.setInt(5, (Integer) listField.getChamp5());
                pstmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }else if (Objects.equals(tabName, "TRANSFERT")) {

            String sql = "INSERT INTO '" + tabName + "' (ID, NUMERO_DEBITEUR, NUMERO_CREDITEUR, DATE, DESCRIPTION, MONTANTDEPOSE, MONTANTRETIRE) VALUES(?,?,?,?,?,?,?)";
            try (Connection conn = connect();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, (Integer) listField.getChamp1());
                pstmt.setInt(2, (Integer) listField.getChamp2());
                pstmt.setInt(3, (Integer) listField.getChamp3());
                pstmt.setString(4, String.valueOf(listField.getChamp4()));
                pstmt.setString(5, (String) listField.getChamp5());
                pstmt.setDouble(6, (Double) listField.getChamp6());
                pstmt.setDouble(7, (Double) listField.getChamp7());
                pstmt.executeUpdate();

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        else if (Objects.equals(tabName, "TRANSACTION")) {

            String sql = "INSERT INTO '" + tabName + "' (ID, ISDEPOT, NUMERO_COMPTE, MONTANT, DATE ) VALUES(?,?,?,?,?)";
            try (Connection conn = connect();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, (Integer) listField.getChamp1());
                pstmt.setString(2, String.valueOf( listField.getChamp2()));
                pstmt.setInt(3, (Integer) listField.getChamp3());
                pstmt.setDouble(4, (Double) listField.getChamp4());
                pstmt.setString(5, String.valueOf(listField.getChamp5()));


                pstmt.executeUpdate();
                System.out.println("save");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
        public static Map <Integer,List<Object>> loadData (String tabName) {

            tabName = tabName.toUpperCase();
            int i=0, t = 0;
            List<Object> listData = new ArrayList<Object>();
            Map <Integer,List<Object>>listDataAll = new HashMap<Integer,List<Object>>();

            if(Objects.equals(tabName, "CLIENT")){

                String sql = "SELECT * FROM '" + tabName + "'";

                try (Connection conn = connect();
                     Statement stmt  = conn.createStatement();
                     ResultSet rs    = stmt.executeQuery(sql)){

                    while (rs.next()) {

                        System.out.println("enter the next");
                        String typeClient = rs.getString("TYPE_CLIENT");
                        listData.add(i, typeClient);
                        String nom = rs.getString("NOM_COMPLET");
                        listData.add(i + 1, nom);
                        String sexe = rs.getString("SEXE");
                        listData.add(i + 2, sexe);
                        String addresse = rs.getString("ADDRESSE");
                        listData.add(i + 3, addresse);
                        int tel = rs.getInt("TEL");
                        listData.add(i + 4, tel);
                        int cin = rs.getInt("CIN_or_NIF");
                        listData.add(i + 5, cin);
                        listDataAll.put(t,listData);
                        for(Map.Entry m: listDataAll.entrySet()){

                            System.out.println(m.getValue());
                        }

                        t++;
                        System.out.println("value "+t);


                    }
                    System.out.println("Data load");

                } catch (Exception e) {
                    System.err.println(e.getClass().getName() + ": " + e.getMessage());
                    System.exit(0);
                }

                System.out.println(listDataAll.get(0));
            }else if(Objects.equals(tabName, "COMPTE")) {

                String sql = "SELECT * FROM '" + tabName + "'";

                try (Connection conn = connect();
                     Statement stmt = conn.createStatement();
                     ResultSet rs = stmt.executeQuery(sql)) {

                    while (rs.next()) {

                        System.out.println("enter the next2");
                        int numeroUniq = rs.getInt("NUMERO_UNIQ");
                        listData.add(i, numeroUniq);
                        String typeCompte = rs.getString("TYPE_COMPTE");
                        listData.add(i + 1, typeCompte);
                        Double solde = rs.getDouble("SOLDE");
                        listData.add(i + 2, solde);
                        String etat = rs.getString("ETAT");
                        listData.add(i + 3, etat);
                        String owner = rs.getString("OWNER");
                        listData.add(i + 4, owner);
                        listDataAll.put(t,listData);

                        System.out.println(listDataAll.get(0));
                        System.out.println(listDataAll.get(1));
                        t++;
                    }
                    System.out.println("Data load");

                } catch (Exception e) {
                    System.err.println(e.getClass().getName() + ": " + e.getMessage());
                    System.exit(0);
                }


            }else if(Objects.equals(tabName, "TRANSFERT")) {

                String sql = "SELECT * FROM '" + tabName + "'";

                try (Connection conn = connect();
                     Statement stmt = conn.createStatement();
                     ResultSet rs = stmt.executeQuery(sql)) {

                    while (rs.next()) {

                        int numeroUniq = rs.getInt("ID");
                        listData.add(i, numeroUniq);
                        String numeroDebiteur = rs.getString("NUMERO_DEBITEUR");
                        listData.add(i + 1, numeroDebiteur);
                        String numeroCrediteur = rs.getString("NUMERO_CREDITEUR");
                        listData.add(i + 2, numeroCrediteur);
                        String etat = rs.getString("DATE");
                        listData.add(i + 3, etat);
                        String owner = rs.getString("DESCRIPTION");
                        listData.add(i + 4, owner);
                        int montantDepose = rs.getInt("MONTANTDEPOSE");
                        listData.add(i + 5, montantDepose);
                        int montantRetire = rs.getInt("MONTANTRETIRE");
                        listData.add(i + 6, montantRetire);
                        listDataAll.put(t,listData);

                        System.out.println(listDataAll.get(0));
                        System.out.println(listDataAll.get(1));
                        t++;
                    }
                    System.out.println("Data load");

                } catch (Exception e) {
                    System.err.println(e.getClass().getName() + ": " + e.getMessage());
                    System.exit(0);
                }


            }else if(Objects.equals(tabName, "TRANSACTION")) {

                String sql = "SELECT * FROM '" + tabName + "'";

                try (Connection conn = connect();
                     Statement stmt = conn.createStatement();
                     ResultSet rs = stmt.executeQuery(sql)) {

                    while (rs.next()) {

                        System.out.println("enter the next Transaction");
                        int Id = rs.getInt("ID");
                        listData.add(i, Id);
                        String isDepot = rs.getString("ISDEPOT");
                        listData.add(i + 1, isDepot);
                        Double numeroCompte = rs.getDouble("NUMERO_COMPTE");
                        listData.add(i + 2, numeroCompte);
                        Double solde = rs.getDouble("MONTANT");
                        listData.add(i + 3, solde);
                        String etat = rs.getString("DATE");
                        listData.add(i + 4, etat);

                        listDataAll.put(t,listData);

                        System.out.println(listDataAll.get(0));
                        System.out.println(listDataAll.get(1));
                        t++;
                    }
                    System.out.println("Data load");

                } catch (Exception e) {
                    System.err.println(e.getClass().getName() + ": " + e.getMessage());
                    System.exit(0);
                }


            }

            return listDataAll;
        }
        public static void update (String tabName, List list) {
            if(Objects.equals(tabName, "CLIENT")){
            tabName = tabName.toUpperCase();
            String sql = "UPDATE '"+tabName+"'"+
                    " SET TYPE_CLIENT= ?," +
                    "NOM_COMPLET = ?," +
                    "SEXE = ?," +
                    "ADDRESSE = ?," +
                    "TEL = ?," +
                    "WHERE CIN_or_NIF = ?";

            try (Connection conn = connect();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
                String typeClient;
                String nomComplet;
                String sexe;
                String adresse;
                int Telephone;
                int Nif_Cin;
                // set the corresponding param
                pstmt.setString(1,(String) list.get(0));
                pstmt.setString(2, (String) list.get(1));
                pstmt.setString(3, (String) list.get(2));
                pstmt.setString(4, (String) list.get(3));
                pstmt.setString(5, (String) list.get(4));
                pstmt.setInt(6, (Integer) list.get(5));
                // update
                pstmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        } else if(Objects.equals(tabName, "COMPTE")){
                tabName = tabName.toUpperCase();
                String sql = "UPDATE '"+tabName+"'"+
                        " SET TYPE_COMPTE= ?," +
                        "SOLDE = ?"+
                        "ETAT = ?," +
                        "OWNER = ?," +
                        "WHERE NUMERO_UNIQ = ?";

                try (Connection conn = connect();
                     PreparedStatement pstmt = conn.prepareStatement(sql)) {

                    // set the corresponding param
                    pstmt.setString(1,(String) list.get(1));
                    pstmt.setInt(2, (Integer) list.get(2));
                    pstmt.setString(3, (String) list.get(3));
                    pstmt.setString(4, (String) list.get(4));
                    pstmt.setInt(5, (Integer) list.get(0));

                    // update
                    pstmt.executeUpdate();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            } else if(Objects.equals(tabName, "TRANSFERT")){
                tabName = tabName.toUpperCase();
                String sql = "UPDATE '"+tabName+"'"+
                        " SET NUMERO_DEBITEUR = ?," +
                        "NUMERO_CREDITEUR = ?"+
                        "DATE = ?," +
                        "DESCRIPTION = ?," +
                        "MONTANTDEPOSE = ?"+
                        "MONTANTRETIRE = ?"+
                        "WHERE ID = ?";

                try (Connection conn = connect();
                     PreparedStatement pstmt = conn.prepareStatement(sql)) {

                    // set the corresponding param
                    pstmt.setInt(1,(Integer) list.get(1));
                    pstmt.setInt(2, (Integer) list.get(2));
                    pstmt.setString(3, (String) list.get(3));
                    pstmt.setString(4, (String) list.get(4));
                    pstmt.setInt(5, (Integer) list.get(5));
                    pstmt.setInt(6, (Integer) list.get(6));
                    pstmt.setInt(7, (Integer) list.get(0));
                    // update
                    pstmt.executeUpdate();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            } else if(Objects.equals(tabName, "TRANSACTION")){
                tabName = tabName.toUpperCase();
                String sql = "UPDATE '"+tabName+"'"+
                        " SET ISDEPOT = ?, " +
                        "NUMERO_COMPTE = ?, " +
                        "MONTANT = ?, " +
                        "DATE = ?"+
                        "WHERE ID = ?";

                try (Connection conn = connect();
                     PreparedStatement pstmt = conn.prepareStatement(sql)) {

                    // set the corresponding param
                    pstmt.setString(1,(String) list.get(1));
                    pstmt.setInt(2, (Integer) list.get(2));
                    pstmt.setInt(3, (Integer) list.get(3));
                    pstmt.setString(4, (String) list.get(4));
                    pstmt.setInt(5, (Integer) list.get(0));

                    // update
                    pstmt.executeUpdate();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
    }

    }
