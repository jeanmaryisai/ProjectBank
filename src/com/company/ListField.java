package com.company;

import java.time.LocalDate;

public class ListField {
    private Object champ1;
    private Object champ2;
    private Object champ3;
    private Object champ4;
    private Object champ5;
    private Object champ6;
    private Object champ7;
    private Object champ8;

    public ListField(int champ1, String champ2, String champ3, String champ4, String champ5,int champ6) {
        this.champ1 = champ1;
        this.champ2 = champ2;
        this.champ3 = champ3;
        this.champ4 = champ4;
        this.champ5 = champ5;
        this.champ6 = champ6;

    }

    public ListField(int champ1, boolean champ2, double champ3, String champ4, int champ5) {
        this.champ1 = champ1;
        this.champ2 = champ2;
        this.champ3 = champ3;
        this.champ4 = champ4;
        this.champ5 = champ5;
    }
    public ListField(int champ1,boolean champ2, int champ3, double champ4, LocalDate champ5) {
        this.champ1 = champ1;
        this.champ2 = champ2;
        this.champ3 = champ3;
        this.champ4 = champ4;
        this.champ5 = champ5;

    }
    public ListField(int champ1,int champ2, int champ3, LocalDate champ4, String champ5,double champ6,double champ7) {
        this.champ1 = champ1;
        this.champ2 = champ2;
        this.champ3 = champ3;
        this.champ4 = champ4;
        this.champ5 = champ5;
        this.champ6 = champ6;
        this.champ7 = champ7;
    }

    public ListField() {
    }

    public Object getChamp1() {
        return champ1;
    }

    public void setChamp1(Object champ1) {
        this.champ1 = champ1;
    }

    public Object getChamp2() {
        return champ2;
    }

    public void setChamp2(Object champ2) {
        this.champ2 = champ2;
    }

    public Object getChamp3() {
        return champ3;
    }

    public void setChamp3(Object champ3) {
        this.champ3 = champ3;
    }

    public Object getChamp4() {
        return champ4;
    }

    public void setChamp4(Object champ4) {
        this.champ4 = champ4;
    }

    public Object getChamp5() {
        return champ5;
    }

    public void setChamp5(Object champ5) {
        this.champ5 = champ5;
    }

    public Object getChamp6() {
        return champ6;
    }

    public void setChamp6(Object champ6) {
        this.champ6 = champ6;
    }

    public Object getChamp7() {
        return champ7;
    }

    public void setChamp7(Object champ7) {
        this.champ7 = champ7;
    }
}