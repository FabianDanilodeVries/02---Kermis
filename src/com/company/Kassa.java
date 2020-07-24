package com.company;
import java.util.Scanner;

class Kassa {
    int totaalAantalKaartjes;
    BotsAuto botsAuto = new BotsAuto("Botsauto's", 2.5, 0,0, 50);
    Spin spin = new Spin("Spin", 2.25, 0,0,50, 0, 5);
    SpiegelPaleis spiegelPaleis = new SpiegelPaleis("Spiegel paleis", 2.75, 0,0,50);
    Spookhuis spookhuis = new Spookhuis("Spookhuis", 3.20, 0,0,50);
    Hawaii hawaii = new Hawaii("Hawaii", 2.90, 0,0,50, 0, 10);
    LadderKlimmen ladderKlimmen = new LadderKlimmen("Ladder klimmen", 5.0, 0,0,50);
    Attractie[] attracties = { botsAuto, spin, spiegelPaleis, spookhuis, hawaii, ladderKlimmen };

    void starten() {
        boolean doorgaan = true;
        while (doorgaan) {
            String attractieKeuze = vraagOmAttractieKeuze();
            switch (attractieKeuze) {
                case "stop", "Stop":
                    doorgaan = false;
                    for(Attractie i : attracties) {
                        if (i.aantalKaartjes > 0) {
                            System.out.println(i.attractieNaam + " - Kaartjes: " + i.aantalKaartjes + ", Omzet: " + i.attractieOmzet + " euro");
                        }
                    }
                    System.out.println("Er zijn totaal " + totaalAantalKaartjes + " kaartjes verkocht");
                    System.out.println("De totale omzet is: " + getTotaleOmzet() + " euro");
                    break;
                case "o":
                    vraagOmOmzet();
                    break;
                case "k":
                    vraagOmAantalKaartjes();
                    break;
                case "m":
                    spin.opstellingsKeuring();
                    hawaii.opstellingsKeuring();
                    break;
                case "b":
                    spin.kansSpelBelastingBetalen();
                    ladderKlimmen.kansSpelBelastingBetalen();
                    break;
                case "1":
                    draaien(botsAuto);
                    break;
                case "2":
                    if (spin.aantalKeerGedraait >= spin.draaiLimiet) {
                        System.out.println(spin.attractieNaam +  " heeft het draai limiet van " + spin.draaiLimiet + " bereikt en moet eerst gekeurd worden (invoer: m)");
                    } else {
                        draaien(spin);
                    }
                    break;
                case "3":
                    draaien(spiegelPaleis);
                    break;
                case "4":
                    draaien(spookhuis);
                    break;
                case "5":
                    if (hawaii.aantalKeerGedraait >= hawaii.draaiLimiet) {
                        System.out.println(hawaii.attractieNaam +  " heeft het draai limiet van " + hawaii.draaiLimiet + " bereikt en moet eerst gekeurd worden (invoer: m)");
                    } else {
                        draaien(hawaii);
                    }
                    break;
                case "6":
                    draaien(ladderKlimmen);
                    break;
            }
        }
    }
    void draaien(Attractie keuze) {
        if (keuze instanceof RisicoRijkeAttracties) {
            ((RisicoRijkeAttracties) keuze).aantalKeerGedraait++;
        }
        System.out.println(keuze.attractieNaam + " draait");
        keuze.aantalKaartjes++;
        totaalAantalKaartjes++;
        keuze.attractieOmzet += keuze.attractiePrijs;
    }
    String vraagOmAttractieKeuze() {
        System.out.println("\r\nWelke attractie wil je bedienen?");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
    void vraagOmOmzet() {
        for(Attractie i : attracties) {
            if (i.aantalKaartjes > 0) {
                System.out.println("Omzet " + i.attractieNaam + ": " + roundToTwoDecimals(i.attractieOmzet) + " euro");
            }
        }
        System.out.println("Totale omzet: " + getTotaleOmzet() + " euro");
    }
    void vraagOmAantalKaartjes() {
        for(Attractie i : attracties) {
            if (i.aantalKaartjes > 0) {
                System.out.println("Aantal verkochte kaartjes " + i.attractieNaam + ": " + i.aantalKaartjes);
            }
        }
        System.out.println("Totale kaartverkoop: " + totaalAantalKaartjes);
    }
    double getTotaleOmzet() {
        double totaleOmzet = 0;
        for (Attractie keuze : attracties) {
            totaleOmzet += keuze.attractieOmzet;
        }
        return totaleOmzet;
    }
    public double roundToTwoDecimals(double i) {
        return Math.round(i * 100.0)/100.0;
    }
}
