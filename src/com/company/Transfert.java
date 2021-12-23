package com.company;
import java.time.LocalDate;

public class Transfert {
    int idTransfert;
    int numeroCompteDebiteur;
    int numeroCompteCrediteur;
    LocalDate dateTransaction;
    String description;
    double montantDepose;
    double montantRetire;

    public Transfert(int numeroCompteDebiteur, int numeroCompteCrediteur, LocalDate dateTransaction, String description, double montantDepose, double montantRetire) {
        this.numeroCompteDebiteur = numeroCompteDebiteur;
        this.numeroCompteCrediteur = numeroCompteCrediteur;
        this.dateTransaction = dateTransaction;
        this.description = description;
        this.montantDepose = montantDepose;
        this.montantRetire = montantRetire;
    }
    public int getIdTransfert() {
        return idTransfert;
    }

    public void setIdTransfert(int idTransfert) {
        this.idTransfert = idTransfert;
    }

    public int getNumeroCompteDebiteur() {
        return numeroCompteDebiteur;
    }

    public void setNumeroCompteDebiteur(int numeroCompteDebiteur) {
        boolean existe=false;
        for(int i=0;i<Dao.getComptes().size();i++){
            if(numeroCompteDebiteur==Dao.getComptes().get(i).numeroUnique){
                existe=true;
            }
        }
        if(!existe){
            Tools.d("Le compte Debiteur n'existe pas!");
        }else{
            this.numeroCompteDebiteur = numeroCompteDebiteur;
        }
    }

    public int getNumeroCompteCrediteur() {
        return numeroCompteCrediteur;
    }

    public void setNumeroCompteCrediteur(int numeroCompteCrediteur) {
        boolean existe=false;
        for(int i=0;i<Dao.getComptes().size();i++){
            if(numeroCompteDebiteur==Dao.getComptes().get(i).numeroUnique){
                existe=true;
            }
        }
        if(!existe){
            Tools.d("Le compte Crebiteur n'existe pas!");
        }else{
            this.numeroCompteCrediteur = numeroCompteCrediteur;
        }

    }

    public LocalDate getDateTransaction() {
        return dateTransaction;
    }

    public void setDateTransaction(LocalDate dateTransaction) {
        this.dateTransaction = dateTransaction;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getMontantDepose() {
        return montantDepose;
    }

    public void setMontantDepose(double montantDepose) {
        this.montantDepose = montantDepose;
    }

    public double getMontantRetire() {
        return montantRetire;
    }

    public void setMontantRetire(double montantRetire) {
        this.montantRetire = montantRetire;
    }
}
