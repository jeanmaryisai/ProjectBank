package com.company;

import java.lang.reflect.Array;

import static com.company.Dao.*;

public class Main {

    public static void main(String[] args) {

        //just for test
        TypeCompte type1=new TypeCompte(true,true);
        Client client1= new Client("Personne","Isai","Masculin","Rue Audant #32",39305866,123);
        Compte compte1=new Compte(123,type1,200,'f',client1);
        client1.comptes.add(compte1);
        clients.add(client1);
        comptes.add(compte1);
        newClient();
        //rechercherClient();
        modifierClient();
        modifierCompte();
        newCompte();

    }
}
