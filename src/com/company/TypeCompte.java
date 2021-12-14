package com.company;

public class TypeCompte {
    boolean Isgourde;
    boolean Isepargne;
    boolean Isdollar= !Isgourde;
    boolean Iscourrant= !Isepargne;

    public boolean isIsgourde() {
        return Isgourde;
    }

    public void setIsgourde(boolean isgourde) {
        Isgourde = isgourde;
    }

    public boolean isIsepargne() {
        return Isepargne;
    }

    public void setIsepargne(boolean isepargne) {
        Isepargne = isepargne;
    }

    public TypeCompte(boolean isgourde, boolean isepargne) {
        Isgourde = isgourde;
        Isepargne = isepargne;
    }

    public TypeCompte() {

    }
}
