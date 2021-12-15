package com.company;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static com.company.Tools.*;

public abstract class Dao {
    public static List<Compte> comptes = new ArrayList<>();
    List<Transfert> transferts = new ArrayList<>();
    public static List<Transaction> transactions = new ArrayList<>();
    static List<Client> clients = new ArrayList<>();
    public static int currentRange = 0;



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
