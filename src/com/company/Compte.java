package com.company;

import java.util.ArrayList;
import java.util.List;

public class Compte {
    int numeroUnique;
    TypeCompte type;
    double solde;
    Character etat;
    Client owner;
    List<Transaction> transactions= new ArrayList<>();

    public Compte(TypeCompte type, String monaie, double solde, Character etat) {
        this.type = type;
        this.solde = solde;
        this.etat = etat;
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

    public Character getEtat() {
        return etat;
    }

    public void setEtat(Character etat) {
        this.etat = etat;
    }

    public Compte() {
    }
}
