package com.company;

import java.time.LocalDate;

public class Transaction {
    int numTrans;
    boolean isDepot;
    int numeroCompte;
    double montant;
    LocalDate date;
    String nomDeposant;
    public Transaction(int numTrans,boolean isDepot, int numeroCompte, double montant, LocalDate date) {
        this.isDepot = isDepot;
        this.numeroCompte = numeroCompte;
        this.montant = montant;
        this.date = date;
    }

    public Transaction() {
    }

    public boolean isDepot() {
        return isDepot;
    }
    public void setDepot(boolean depot) {
        isDepot = depot;
    }

    public int getNumeroCompte() {
        return numeroCompte;
    }

    public void setNumeroCompte(int numeroCompte) {
        this.numeroCompte = numeroCompte;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getNomDeposant() {
        return nomDeposant;
    }

    public void setNomDeposant(String nomDeposant) {
        boolean existe=true;
        for(int i=0;i<Dao.getComptes().size();i++){
            if(numeroCompte==Dao.getComptes().get(i).numeroUnique){
                existe=true;
                this.nomDeposant = Dao.getComptes().get(i).getOwner().nomComplet;

            }
        }
        if(!existe){
            Tools.d("Le compte n'existe pas!");
        }
    }
}
