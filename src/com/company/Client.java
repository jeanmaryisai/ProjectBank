package com.company;

import java.util.ArrayList;
import java.util.List;

import static com.company.Dao.clients;
import static com.company.Tools.*;

public class Client {

    public List<Compte> comptes=new ArrayList<>();
    String typeClient;
    String nomComplet;
    String sexe;
    String adresse;
    long Telephone;
    String Nif_Cin;

    public Client( String typeClient, String nomComplet, String sexe, String adresse, int telephone, String nif_Cin) {
        this.typeClient = typeClient;
        this.nomComplet = nomComplet;
        this.sexe = sexe;
        this.adresse = adresse;
        Telephone = telephone;
        Nif_Cin = nif_Cin;
    }
    public void save(){
        ListField listField = new ListField(Nif_Cin,typeClient, nomComplet, sexe, adresse, Telephone);
        Sqlcon.save(  "Transfert", listField);
    }

    public Client() {

    }

    public List<Compte> getComptes() {
        return comptes;
    }

    public void setComptes(List<Compte> comptes) {
        this.comptes = comptes;
    }

    public String getTypeClient() {
        return typeClient;
    }

    public void setTypeClient(String typeClient) {
        this.typeClient = typeClient;
    }

    public String getNomComplet() {
        return nomComplet;
    }

    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public long getTelephone() {
        return Telephone;
    }

    public void setTelephone(long telephone) {
        Telephone = telephone;
    }

    public String getNif_Cin() {
        return Nif_Cin;
    }

    public void setNif_Cin(String nif_Cin) {
        for (Client c:
             clients) {
            if(c.getNif_Cin().equals(nif_Cin)){
                d("Cin/Nif deja pris!");return;
            }
        }
        Nif_Cin = nif_Cin;
    }
    @Override
    public String toString(){
        String devise="gourde";
        d("Nom: "+nomComplet+"\n" +
                "sexe: "+sexe+"\n" +
                "Telephone "+getTelephone()+"\n");
        if(typeClient.equals("Entreprise"))d("Id: "+getNif_Cin());
        else d("Nif/Cin " +getNif_Cin()+"\n");
        d("Adresse " +adresse+"\n"+
                "TypeClient "+typeClient+"\n" +
                "Comptes associees->{"
        );
        for (Compte x:
             comptes) {
            d("Compte "+x.numeroUnique);
        }d("}");
        return null;
    }
}
