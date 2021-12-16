package com.company;
import static com.company.Tools.*;
import java.time.LocalDate;

public class Transaction {
    boolean isDepot;
    int id;
    String numeroCompte;
    double montant;
    LocalDate date;
    String nomDeposant;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Transaction(boolean isDepot, String numeroCompte, double montant, LocalDate date) {
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

    public String getNumeroCompte() {
        return numeroCompte;
    }

    public void setNumeroCompte(String numeroCompte) {
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
            if(numeroCompte.equals(Dao.getComptes().get(i).numeroUnique)){
                existe=true;
                this.nomDeposant = Dao.getComptes().get(i).getOwner().nomComplet;

            }
        }
        if(!existe){
            d("Le compte n'existe pas!");
        }
    }
    public String toString(){
        if(isDepot){
            d("Id transaction: "+id);
            d("Type de Transaction: Depot");
        }else d("Type de transaction retrait");
        d("Montant: "+Math.sqrt(montant*montant));
        d("Numero de compte: "+numeroCompte);
        d("Date de la transaction: "+date.toString());
        d("Nom du deposant: "+ nomDeposant);
        return null;
    }
}
