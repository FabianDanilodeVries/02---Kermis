package com.company;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        new Main().programmabedienen();
    }
    void programmabedienen() {
        Kassa kassa = new Kassa();
        kassa.starten();
    }
}

class Kassa {
    double totaleOmzet;
    Attractie botsAuto = new BotsAuto("Botsauto's", 5.0, 0, 50);
    Attractie spin = new BotsAuto("Spin", 5.0, 0,50);
    Attractie spiegelpaleis = new BotsAuto("Spiegelpaleis", 5.0, 0,50);
    void draaien(Attractie keuze) {
        System.out.println(keuze.attractieNaam + " draait");
        keuze.attractieOmzet += keuze.attractiePrijs;
        totaleOmzet += keuze.attractiePrijs;
    }

    void starten() {
        boolean doorgaan = true;
        while (doorgaan) {
            String attractieKeuze = vraagOmAttractieKeuze();
            switch (attractieKeuze) {
                case "stop":
                    doorgaan = false;
                    System.out.println("De totale omzet is: " + totaleOmzet);
                    break;
                case "1":
                    draaien(botsAuto);
                    break;
                case "2":
                    draaien(spin);
                    break;
                case "3":
                    draaien(spiegelpaleis);
                    break;
                case "4":
                    System.out.println("Spookhuis");
                    break;
                case "5":
                    System.out.println("Hawaii");
                    break;
                case "6":
                    System.out.println("Ladderklimmen");
                    break;
            }
        }
    }
    String vraagOmAttractieKeuze() {
        System.out.println("Welke attractie wil je bedienen?");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}