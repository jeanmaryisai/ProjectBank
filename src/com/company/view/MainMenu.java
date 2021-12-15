package com.company.view;

import static com.company.Dao.*;
import static com.company.Tools.*;
import static com.company.methodes.*;

public abstract class MainMenu {
    public static int mainMenu(){int i;
        do {
            d("Menu principale\n" +
                    "Presser 1 pour le module clients" +
                    "\nPresser 2 pour le module comptes" +
                    "\nPresser 3 pour le module transactions." +
                    "\nPresser 4 pour quitter le programme");
        i=ei();
        }while (i!=1&&i!=2&&i!=3);
        return i;
    }
    public static void menuPrincipale(){boolean stay=true;
        do {
            switch (mainMenu()){
                case 1:moduleClients();break;
                case 2:moduleComptes();break;
                case 3:test(3);break;
                case 4:test(4);stay=false;
            }
        }while (stay);
    }
    public static void moduleClients() {
        int choix;
        boolean stay = true;
        do {
            do {
                d("Presser 1 pour creer un client\n" +
                        "presser 2 pour rechercher un client\n" +
                        "presser 3 pour lister tous les client\n" +
                        "presser 4 pour modifier un client\n" +
                        "presser 5 pour retourner au menu principale"
                );
                choix = ei();
            } while (choix != 1 && choix != 2 && choix != 3 && choix != 4&&choix!=5);

            switch (choix){
                case 1:newClient();break;
                case 2:rechercherClient();break;
                case 3:listerClient();break;
                case 5:stay=false;break;
                case 4:modifierClient();break;
            }
        } while (stay);
    }
    public static void moduleComptes() {
        int choix;
        boolean stay = true;
        do {
            do {
                d("Presser 1 pour creer un nouveaau comptes\n" +
                        "presser 2 pour rechercher un comptes\n" +
                        "presser 3 pour lister tous les comptes\n" +
                        "presser 4 pour modifier un comptes\n" +
                        "presser 5 pour supprimer un compte\n" +
                        "presser 6 pour retourner au menu principale"
                );
                choix = ei();
            } while (choix != 1 && choix != 2 && choix != 3 && choix != 4&&choix!=5&&choix!=6);

            switch (choix){
                case 1:newCompte();break;
                case 2:rechercherCompte();break;
                case 3:listerComptes();break;
                case 6:stay=false;break;
                case 4:modifierCompte();break;
                case 5:supprimerCompte();break;
            }
        } while (stay);
    }
    public static void moduleTrasaction(){
        int choix;
        boolean stay = true;
        do {
            do {
                d("Presser 1 pour faire un depot/retrait\n" +
                        "presser 2 pour faire un transfert\n" +
                        "presser 3 pour lister tous les transaction\n" +
                        "presser 4 pour rechercher un transaction\n" +
                        "presser 5 pour retourner au menu principale"
                );
                choix = ei();
            } while (choix != 1 && choix != 2 && choix != 3 && choix != 4&&choix!=5);

            switch (choix){
                case 1:newTransaction();break;
                case 2:rechercherClient();break;
                case 3:listerClient();break;
                case 5:stay=false;break;
                case 4:modifierClient();break;
            }
        } while (stay);
    }
}
