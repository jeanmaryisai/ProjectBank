package com.company;

import java.time.LocalDate;
import java.util.Random;

import static com.company.Dao.*;
import static com.company.Tools.*;


public abstract class methodes {


    //client
    public static void newClient() {
        d("Veuiller entrer:");
        System.out.printf("\nLe nom complet du Client->");
        Client client = new Client();
        client.setNomComplet(e());
        String v;
        do {
            d("\nLe sexe du Client(\"m\" pour masculin,\"f\" pour feminin et \"a\" pour aucun)->");
            v = e();
        } while (!v.equals("m") && !v.equals("f") && !v.equals("a"));
        switch (v) {
            case "m":
                client.setSexe("Masculin");
                client.setTypeClient("Compte personnel");
                break;
            case "f":
                client.setSexe("feminin");
                client.setTypeClient("Compte personnel");
                break;
            case "a":
                client.setSexe("Aucun");
                d("Ce client est-il un entreprise?");
                if (isvalide()) client.setTypeClient("Entreprise");
                break;
        }
        d("Entrer l'adresse du client");
        client.setAdresse(e());
        d("Entrer le numero de telephone du client");
        client.setTelephone(ei());
        long ni = 0;
        boolean is = false;
        String nif = "";
        try {
            if (client.typeClient.equals("Entreprise")) {
                boolean dd = true;
                while (dd) {
                    dd = false;
                    nif = randomEId();
                    for (Client x :
                            clients) {
                        if (nif.equals(x.Nif_Cin)) dd = true;
                    }
                }
                d("Id: " + nif + " assigner");
            } else {
                do {
                    d("Enter le nif ou Cin du client");
                    ni = ei();
                    nif = String.valueOf(ni);
                    for (Client x : clients) {
                        if (x.getNif_Cin().equals(nif)) {
                            d("Nif deja enregistre!\n" +
                                    "Nif appartenant au client " + x.nomComplet +
                                    "\nSouaiter vous entrer un autre nif encore une fois");
                            if (!isvalide()) return;
                            else is = true;
                        }
                    }
                } while (is);

            }
            client.setNif_Cin(nif);
        } catch (Exception e) {
        }
        d("Entrer le montant de depot initiale");
        Transaction transaction=new Transaction();
        transaction.isDepot=true;
        nc(client);
        currentRange++;
        clients.add(client);
        d("Client enregistre!");
    }

    public static Client searchc() {
        d("Entrer le nif/cin ou Id du client");
        String nifs = e();
        for (Client x :
                clients) {
            if (nifs.equals(x.Nif_Cin)) {
                return x;
            } else {
                d("Le client ne peut etre retrouve !");
            }
        }
        return null;
    }

    public static void rechercherClient() {
        if (clients.size() == 0) {
            d("Aucun client enregistre!");
            return;
        }
        Client c = new Client();
        try {
            c = searchc();
            c.toString();
        } catch (Exception e) {
            return;
        }

    }

    public static void modifierClient() {
        if (clients.size() == 0) {
            d("Aucun client enregistre!");
            return;
        }
        try {
            Client client = searchc();
            client.toString();
            d("Souhaiter vous modifier le nom du client?");
            if (isvalide()) {
                d("entrer le nom");
                client.setNomComplet(e());
            }
            d("Souhaiter vous modifier le sexe du client?");
            if (isvalide()) {
                d("entrer le sexe");
                client.setSexe(e());
            }
            d("Souhaiter vous modifier l'adresse du client?");
            if (isvalide()) {
                d("entrer l'adresse");
                client.setAdresse(e());
            }
            d("Souhaiter vous modifier le numero de telephone du client?");
            if (isvalide()) {
                d("entrer le numero de telephone");
                client.setTelephone(ei());
            }
            d("Souhaiter vous modifier le nif/cin du client?");
            if (isvalide()) {
                d("entrer le nif/cin");
                client.setNif_Cin(String.valueOf(el()));
            }
            d("Souhaiter vous modifier le type du client?");
            if (isvalide()) {
                d("entrer le type");
                client.setTypeClient(e());
            }
            client.toString();
        } catch (Exception e) {
        }

    }

    public static void nc(Client client) {
        System.out.println("Le compte associe, est-il en gourdes?");
        Compte compte = new Compte();
        compte.setOwner(client);
        TypeCompte typeCompte = new TypeCompte();
        typeCompte.setIsgourde(Tools.isvalide());
        compte.setEtat('f');
        System.out.println("Le compte associe, est-il un compte epargne?");
        typeCompte.setIsepargne(Tools.isvalide());
        compte.setType(typeCompte);
        compte.setSolde(0.00);
        boolean vv = true;
        String x = "";
        while (vv) {
            vv = false;
            x = randomCId();
            for (Compte xr : comptes) {
                if (x.equals(xr.numeroUnique)) vv = true;
            }
        }
        compte.setNumeroUnique(x);
        getComptes().add(compte);
        client.getComptes().add(compte);
        d("Compte de Id: " + x + " enregistre!");

    }

    public static void listerClient() {
        for (Client x : clients) {
            d(x.nomComplet + " de nif/cin: " + x.getNif_Cin() + "\n");
        }
    }


    //compte
    public static void newCompte() {
        try {
            Client client = searchc();
            if (!client.equals(null)) {
                if (client.comptes.size() < 4) {
                    TypeCompte typeCompte = new TypeCompte();
                    Compte compte = new Compte();
                    compte.setOwner(client);
                    int i = 0;
                    boolean k = false;
                    int it = 0;
                    boolean kt = false;
                    boolean ktk = false;
                    int itk = 0;
                    for (Compte x :
                            client.comptes) {
                        if (x.type.Isgourde) i++;
                        k = x.type.Isepargne;
                        if (x.type.Isepargne) it++;
                        kt = x.type.Isgourde;
                        if (!x.type.Isgourde) itk++;
                        ktk = x.type.isIsepargne();
                    }
                    compte.setType(typeCompte);
                    compte.setSolde(0.00);
                    if (i == 2) {
                        d("vous ne pouvez que creer un compte en dollar(epargne ou courrant)\n" +
                                "Souhaiter vous continuer?");
                        if (isvalide()) {
                            typeCompte.setIsgourde(false);
                            if (it == 1) {
                                d("Le compte est il un compte epargne?");
                                typeCompte.setIsepargne(isvalide());
                            }
                            if (it == 2) {
                                d("Vous ne pouvez que creer un compte courant\n" +
                                        "Souhaiter vous continuer?");
                                if (isvalide()) typeCompte.setIsepargne(false);
                                else return;
                            }
                            if (it == 0) {
                                d("Vous ne pouvez que creer un compte epargne\n" +
                                        "Souhaiter vous continuer?");
                                if (isvalide()) typeCompte.setIsepargne(true);
                                else return;
                            }
                        } else return;
                    }
                    if (i == 0) {
                        if (client.comptes.size() == 2) {
                            d("Le compte est il un compte epargne?");
                            typeCompte.setIsepargne(isvalide());
                            d("Ce compte ne peut etre qu'en gourde");
                            typeCompte.setIsgourde(true);
                        }
                        if (client.comptes.size() == 1) {
                            if (client.comptes.get(0).type.isIsepargne()) {
                                d("Le compte est il un compte epargne?");
                                if (isvalide()) {
                                    typeCompte.setIsepargne(true);
                                    d("le compte ne peut etre qu'en gourdes");
                                    typeCompte.setIsgourde(true);
                                } else {
                                    typeCompte.setIsepargne(false);
                                    d("Le compte, est-il un compte en gourdes?");
                                    typeCompte.setIsgourde(isvalide());
                                }
                            } else {
                                d("Le compte est il un compte epargne?");
                                if (!isvalide()) {
                                    typeCompte.setIsepargne(false);
                                    d("le compte ne peut etre qu'en gourdes");
                                    typeCompte.setIsgourde(true);
                                } else {
                                    typeCompte.setIsepargne(true);
                                    d("Le compte, est-il un compte en gourdes?");
                                    typeCompte.setIsgourde(isvalide());
                                }
                            }
                        }
                    }
                    if (i == 1) {
                        if (client.comptes.size() == 1) {
                            if (client.comptes.get(0).type.isIsepargne()) {
                                d("Le compte est il un compte epargne?");
                                if (isvalide()) {
                                    typeCompte.setIsepargne(true);
                                    d("le compte ne peut etre qu'en dollars");
                                    typeCompte.setIsgourde(false);
                                } else {
                                    typeCompte.setIsepargne(false);
                                    d("Le compte, est-il un compte en gourdes?");
                                    typeCompte.setIsgourde(isvalide());
                                }
                            } else {
                                d("Le compte est il un compte epargne?");
                                if (!isvalide()) {
                                    typeCompte.setIsepargne(false);
                                    d("le compte ne peut etre qu'en dollars");
                                    typeCompte.setIsgourde(false);
                                } else {
                                    typeCompte.setIsepargne(true);
                                    d("Le compte, est-il un compte en gourdes?");
                                    typeCompte.setIsgourde(isvalide());
                                }
                            }
                        }
                        if (client.comptes.size() == 3) {
                            if (k) {
                                d("Vous ne pouvez que creer un compte courrant en gourde pour ce client");
                                d("Voulez vous y proceder?...");
                                if (isvalide()) {
                                    typeCompte.setIsepargne(false);
                                    typeCompte.setIsgourde(true);
                                } else return;
                            } else {
                                d("Vous ne pouvez que creer un compte epargne en gourde pour ce client");
                                d("Voulez vous y proceder?...");
                                if (isvalide()) {
                                    typeCompte.setIsepargne(true);
                                    typeCompte.setIsgourde(true);
                                } else return;
                            }
                        }
                        if (client.comptes.size() == 2) {
                            if (k) {
                                if (ktk) {
                                    d("Vous ne pouvez creer que de getcompte courrant pour ce client!");
                                    d("Voulez vous proceder...");
                                    if (isvalide()) {
                                        typeCompte.setIsepargne(false);
                                        d("Ce compte est il en gourdes?");
                                        typeCompte.setIsgourde(isvalide());
                                    } else return;
                                } else {
                                    d("Votre compte, est il un compte epargne?");
                                    if (isvalide()) {
                                        d("le compte ne peut etre qu'en dollars");
                                        typeCompte.setIsgourde(false);
                                        typeCompte.setIsepargne(true);
                                    } else {
                                        d("Le compte ne peut etre qu'en gourdes");
                                        typeCompte.setIsepargne(false);
                                        typeCompte.setIsgourde(true);
                                    }
                                }
                            } else {
                                if (!ktk) {
                                    d("Vous ne pouvez creer que de getcompte epargne pour ce client!");
                                    d("Voulez vous proceder...");
                                    if (isvalide()) {
                                        typeCompte.setIsepargne(false);
                                        d("Ce compte est il en gourdes?");
                                        typeCompte.setIsgourde(isvalide());
                                    } else return;
                                } else {
                                    d("Votre compte, est il un compte epargne?");
                                    if (isvalide()) {
                                        d("le compte ne peut etre qu'en gourdes");
                                        typeCompte.setIsgourde(true);
                                        typeCompte.setIsepargne(true);
                                    } else {
                                        d("le compte ne peut etre qu'en dollar");
                                        typeCompte.setIsgourde(!true);
                                        typeCompte.setIsepargne(!true);
                                    }

                                }
                            }
                        }
                    }
                    compte.setEtat('a');
                    getComptes().add(compte);
                    client.comptes.add(compte);
                } else {
                    d("Le client ne peut plus se voir attribuer de getcompte, ses quatre type de compte sont deja attrubuer.");
                }
            }
        } catch (Exception e) {
        }
    }

    public static Compte searchC() {
        d("Veuillez entrer le numero de compte");
        String s = e();
        for (Compte x :
                getComptes()) {
            if (s == x.numeroUnique) return x;
        }
        return null;
    }

    public static void rechercherCompte() {
        Compte compte;
        try {
            compte = searchC();
            compte.toString();
        } catch (Exception e) {
            d("Aucune correspondance trouvee");
            return;
        }

    }

    public static void modifierCompte() {
        try {
            Compte compte = searchC();
            d("Voulez vous modifier l'etat du compte?");
            if (isvalide()) {
                if (compte.etat.equals('f')) {
                    d("Voulez vous decongeler ce compte?");
                    if (!isvalide()) {
                        d("action interrompu!");
                        return;
                    } else {
                        compte.setEtat('a');
                        d("Compte decongeler!");
                    }
                } else {
                    d("Voulez vous congeler ce compte");
                    if (!isvalide()) {
                        d("Action interrompu!");
                        return;
                    } else {
                        compte.setEtat('f');
                        d("Compte congeler!");
                    }
                }
            } else return;
        } catch (Exception e) {
            d("votre compte n'existe pas!");
        }


    }

    public static void listerComptes() {
        for (Compte x : comptes) {
            d("Compte #" + x.numeroUnique + " detenu par " + x.owner.nomComplet + "de nif/cin: " + x.owner.getNif_Cin());
        }
    }

    public static void supprimerCompte() {
        Compte compte;
        try {
            compte = searchC();
        } catch (Exception e) {
            d("Votre compte ne peut etre retrouvee");
            return;
        }
        comptes.remove(compte);
        if (compte.owner.comptes.size() == 1) {
            d("Vous allez proceder a la supression du dernier compte associer du client, en faisant cela vous supprimer aussi le client");
            d("voulez vous proceder?");
            if (isvalide()) {
                compte.owner.comptes.remove(compte);
                clients.remove(compte.owner);
            } else {
                d("Action intterrompu!");
                return;
            }
        }
        compte.owner.comptes.remove(compte);
        d("Le compte a ete suprrimer!");
    }

    //transactions
    public static void newTransaction() {
        Compte compte;
        try {
            compte = searchC();
        } catch (Exception e) {
            d("le compte n'existe pas!");
            return;
        }
        if (compte.etat.equals('f')) {
            d("Vous ne pouvez pas operer des operation sur un comptes innactif");
            return;
        } else {
            Transaction transaction = new Transaction();
            int coeficient = 1;
            d("vous faites un depot?");
            if (!isvalide()) {
                transaction.setDepot(false);
                coeficient = -1;
                if (compte.solde == 0) {
                    d("vous ne pouvez pas faire des retrait sur un compte a solde 0");
                    return;
                }
            } else transaction.setDepot(true);
            d("Entrer le montant");
            double montant = ed() * coeficient;

            if ((montant + compte.solde) < 0) {
                d("Vous ne pouvez pas proceder a ce retrait(le montant est inferieur a votre solde)");
                return;
            }

            transaction.setDate(LocalDate.now());
            transaction.setMontant(montant);
            compte.setSolde((compte.solde + montant));
            transaction.setNomDeposant(compte.getOwner().nomComplet);
            transactions.add(transaction);
            compte.transactions.add(transaction);
        }
    }

    public static void newTransfert() {
        Compte compteD;
        Compte compteC;
        d("Pour le compte debiteur");
        try {
            compteD = searchC();
        } catch (Exception e) {
            d("le compte n'existe pas!");
            return;
        }
        d("Pour le compte crediteur");
        try {
            compteC = searchC();
        } catch (Exception e) {
            d("le compte n'existe pas!");
            return;
        }


    }


}
