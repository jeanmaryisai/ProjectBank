package com.company;

import java.util.ArrayList;
import java.util.List;

public class Compte {
    int numeroUnique;
    TypeCompte type;
    double solde;
    String etat;
    Client owner;
    List<Transaction> transactions= new ArrayList<>();

    public Compte(int numeroUnique, TypeCompte type, double solde, String etat, Client owner) {
        this.numeroUnique = numeroUnique;
        this.type = type;
        this.solde = solde;
        this.etat = etat;
        this.owner = owner;

    }
    public Client getOwner() {
        return owner;
    }

    public void setOwner(Client owner) {
        this.owner = owner;
    }

    public int getNumeroUnique() {
        return numeroUnique;
    }

    public void setNumeroUnique(int numeroUnique) {
        this.numeroUnique = numeroUnique;
    }

    public TypeCompte getType() {
        return type;
    }

    public void setType(TypeCompte type) {
        this.type = type;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public Compte() {
    }

    @Override
    public String toString() {
        return "Compte{" +
                "numeroUnique=" + numeroUnique +
                ", type=" + type +
                ", solde=" + solde +
                ", etat=" + etat +
                ", owner=" + getOwner() +
                ", transactions=" + transactions +
                '}';
    }
}
