package com.company;

import java.lang.reflect.Array;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Arrays;

import static com.company.Dao.*;

public class Main {

    public static void main(String[] args) {
//        Sqlcon.createDatabase("Client");
//        Sqlcon.createDatabase("Compte");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        int time = (int) timestamp.getTime();
        String split = String.valueOf(time);
        split= split.substring(2);
        int uniqNum = Integer.parseInt(split);
//        TypeCompte type1=new TypeCompte(true,true);
//        Client client1= new Client("Personne","Isai","Masculin","Rue Audant #32",39305866,123);
//        Compte compte1=new Compte(uniqNum,type1,200,"f",client1);
//        Compte compte2=new Compte(uniqNum+2,type1,400,"2",client1);
//        client1.comptes.add(compte1);
//        clients.add(client1);
//        comptes.add(compte1);
//        compte1.save();
//        compte2.save();
//        client1.save();
//        Sqlcon.createDatabase("Transaction");
//          Transaction trans = new Transaction(uniqNum,true,9845,900, LocalDate.now());
//          trans.save();
        Sqlcon.loadData("Transaction");

    }
}
