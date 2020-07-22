package com.company;
import java.net.StandardSocketOptions;
import java.util.ArrayList;
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
    int totaalAantalKaartjes;
    Attractie botsAuto = new BotsAuto("Botsauto's", 2.5, 0,0, 50);
    Attractie spin = new Spin("Spin", 2.25, 0,0,50);
    Attractie spiegelPaleis = new SpiegelPaleis("Spiegel paleis", 2.75, 0,0,50);
    Attractie spookhuis = new Spookhuis("Spookhuis", 3.20, 0,0,50);
    Attractie hawaii = new Hawaii("Hawaii", 2.90, 0,0,50);
    Attractie ladderKlimmen = new LadderKlimmen("Ladder klimmen", 5.0, 0,0,50);
    Attractie[] attracties = { botsAuto, spin, spiegelPaleis, spookhuis, hawaii, ladderKlimmen};


    void draaien(Attractie keuze) {
        System.out.println(keuze.attractieNaam + " draait");
        keuze.aantalKaartjes++;
        totaalAantalKaartjes++;
        keuze.attractieOmzet =  keuze.attractieOmzet + keuze.attractiePrijs;
        totaleOmzet = totaleOmzet + keuze.attractiePrijs;
    }

    void starten() {
        boolean doorgaan = true;
        while (doorgaan) {
            String attractieKeuze = vraagOmAttractieKeuze();
            switch (attractieKeuze) {
                case "stop":
                    doorgaan = false;
                    for(Attractie i : attracties) {
                        if (i.aantalKaartjes > 0) {
                            System.out.println(i.attractieNaam + " - Kaartjes: " + i.aantalKaartjes + ", Omzet: " + i.attractieOmzet + " euro");
                        }
                    }
                    System.out.println("Er zijn totaal " + totaalAantalKaartjes + " kaartjes verkocht");
                    System.out.println("De totale omzet is: " + totaleOmzet + " euro");
                    break;
                case "1":
                    draaien(botsAuto);
                    break;
                case "2":
                    draaien(spin);
                    break;
                case "3":
                    draaien(spiegelPaleis);
                    break;
                case "4":
                    draaien(spookhuis);
                    break;
                case "5":
                    draaien(hawaii);
                    break;
                case "6":
                    draaien(ladderKlimmen);
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