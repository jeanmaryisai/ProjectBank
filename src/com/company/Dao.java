package com.company;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static com.company.Tools.*;

public abstract class Dao {
    public static List<Compte> comptes = new ArrayList<>();
    public static List<Transfert>transferts=new ArrayList<>();
    public static List<Transaction> transactions = new ArrayList<>();
    public static List<Client> clients = new ArrayList<>();
    public static int currentRange = 0;
    public static double taux=100;
    public static double montantmin=100;

    public static void setMontantmin() {
        d("L'actuel montant minimal pour ouvrir un compte est de "+montantmin+" gourdes");
        d("Voulez vous poursuivre?");
        if(!isvalide()){
            return;
        }else {
            d("Veuillez entrer le nouveau montant");
            taux=ed();
            d("Nouveau montant minimale pour ouvrir un compte est de: "+montantmin);
        }
    }

    public static void setTaux() {
        d("L'actuel taux est de "+taux+" USD/HTG");
        d("Voulez vous poursuivre?");
        if(!isvalide()){
            return;
        }else {
            d("Veuillez entrer le nouveau taux");
            taux=ed();
            d("Nouveau taux: "+taux);
        }
    }

    public static List<Compte> getComptes() {
        return comptes;
    }

    public static void setComptes(List<Compte> comptes) {
        Dao.comptes = comptes;
    }

    public List<Transfert> getTransferts() {
        return transferts;
    }

    public void setTransferts(List<Transfert> transferts) {
        this.transferts = transferts;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
}
