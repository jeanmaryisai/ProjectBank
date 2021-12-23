package com.company;
import static com.company.Tools.*;
import java.util.ArrayList;
import java.util.List;

public class Compte {
    String numeroUnique;
    TypeCompte type;
    double solde;
    Character etat;
    Client owner;
   public List<Transaction> transactions= new ArrayList<>();
    List<Transfert> transferts= new ArrayList<>();

    public Compte(int numeroUnique, TypeCompte type, double solde, Character etat, Client owner) {

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

    public String getNumeroUnique() {
        return numeroUnique;
    }

    public void setNumeroUnique(String numeroUnique) {
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
    public String toString(){
        d("Compte numero: "+numeroUnique);
        d("Nif Proprietaire: "+owner.getNif_Cin());
        d("Nom Proprietaire: "+ owner.nomComplet);
        if(etat.equals('f'))d("Etat: Fermer");
        else {
            d("Etat: Actif" +
                    "\nSolde: "+solde
                    );
            if (type.Isgourde)d("Monnaie: gourdes");
            else d("Monnaie: Dollars");
            if(type.Isepargne)d("Type de compte: Epargne");
            else d("Type de compte: courrant");
            d("Transactions associees->{");
            for (Transaction x:
                 transactions) {
                d("Transaction "+x.id);
            }
            for(Transfert x:transferts){
                d("Transaction "+x.idTransfert);
            }
        }
        return null;
    }
}
