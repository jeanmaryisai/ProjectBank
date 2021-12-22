package com.company;
import java.time.LocalDate;

import static com.company.Tools.d;

public class Transfert {
    String idTransfert;
    String numeroCompteDebiteur;
    String numeroCompteCrediteur;
    LocalDate dateTransaction;
    String description;
    double montantDepose;
    double montantRetire;
    public String devise;

    public Transfert(String idTransfert, String numeroCompteDebiteur, String numeroCompteCrediteur, LocalDate dateTransaction, String description, double montantDepose, double montantRetire) {
        this.idTransfert = idTransfert;
        this.numeroCompteDebiteur = numeroCompteDebiteur;
        this.numeroCompteCrediteur = numeroCompteCrediteur;
        this.dateTransaction = dateTransaction;
        this.description = description;
        this.montantDepose = montantDepose;
        this.montantRetire = montantRetire;
    }

    public String getIdTransfert() {
        return idTransfert;
    }

    public void setIdTransfert(String idTransfert) {
        this.idTransfert = idTransfert;
    }

    public String getNumeroCompteDebiteur() {
        return numeroCompteDebiteur;
    }

    public void setNumeroCompteDebiteur(String numeroCompteDebiteur) {
        boolean existe=false;
        for(int i=0;i<Dao.getComptes().size();i++){
            if(numeroCompteDebiteur.equals(Dao.getComptes().get(i).numeroUnique)){
                existe=true;
            }
        }
        if(!existe){
            d("Le compte Debiteur n'existe pas!");
        }else{
            this.numeroCompteDebiteur = numeroCompteDebiteur;
        }
    }

    public String getNumeroCompteCrediteur() {
        return numeroCompteCrediteur;
    }

    public void setNumeroCompteCrediteur(String numeroCompteCrediteur) {
        boolean existe=false;
        for(int i=0;i<Dao.getComptes().size();i++){
            if(numeroCompteDebiteur==Dao.getComptes().get(i).numeroUnique){
                existe=true;
            }
        }
        if(!existe){
            d("Le compte Crebiteur n'existe pas!");
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
    public String toString(){

        d("Id Transaction: "+idTransfert+"\n" +
                "Type: Transfert" +
                "\nMontant deposee: "+ montantDepose+" "+devise+
                "\nMontant retiree: "+ montantRetire+" "+devise+
                "\nCompte debiteur: "+ numeroCompteDebiteur
                +"\nCompte Crediteur: "+numeroCompteCrediteur+
                "\nDate de transfert: "+ dateTransaction.toString());
        return null;
    }
}
