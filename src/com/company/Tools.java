package com.company;

import java.util.Random;
import java.util.Scanner;

public abstract class Tools {
    public static int ei(){
        try{

            Scanner x=new Scanner(System.in);
            int i=x.nextInt();
            return i;
        }catch (Exception e){
            System.out.println("Please enter an Interger");
            return ei();
        }
    }
    public static long el(){
        try{

            Scanner x=new Scanner(System.in);
            long i=x.nextLong();
            return i;
        }catch (Exception e){
            System.out.println("Please enter an Interger");
            return ei();
        }
    }
    public static String randomEId(){
        Random x=new Random(1);
        x.nextInt(99999);
        int i=  (x.nextInt(99999)+100000);
        String v="Ecr-"+String.valueOf(i);
        return v;
    }
    public static String randomCId(){
        Random x=new Random(1);
        x.nextInt(99999);
        int i=  (x.nextInt(99999)+100000);
        String v="Ccr-"+i;
        return v;
    }
    public static String randomTId(){
        Random x=new Random(1);
        x.nextInt(99999);
        int i=  (x.nextInt(99999)+100000);
        String v="Tcr-"+i;
        return v;
    }
    public static String randomTransfertId(){
        Random x=new Random(1);
        x.nextInt(99999);
        int i=  (x.nextInt(99999)+100000);
        String v="Trcr-"+String.valueOf(i);
        return v;
    }
    public static boolean isvalide(){
        String v;
        boolean valide=true;
            do {
                System.out.printf("Presser \"y\" pour oui, \"n\" pour non");
                Scanner x = new Scanner(System.in);
                v=x.nextLine();
            }while (!v.equals("y")&&!v.equals("n"));
        if(v.equals("n")) valide=false;
        return valide;
    }
    public static String e(){
            Scanner x=new Scanner(System.in);
            String i=x.nextLine();
            return i;
    }
    public static void br(){
        Scanner x=new Scanner(System.in);
        d("Presser enter pour continuer");
        x.nextLine();
    }
    public static void test(int x){
        System.out.println("Test "+x+" succeed");
    }

    public static double ed(){
        try{

            Scanner x=new Scanner(System.in);
            double i=x.nextInt();
            return i;
        }catch (Exception e){
            System.out.println("Please enter a double!");
            return ed();
        }
    }

    public static void d(Object x){
        System.out.println(x);
    }
}
