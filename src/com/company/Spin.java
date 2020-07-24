package com.company;

public class Spin extends RisicoRijkeAttracties implements Attractie.GokAttractie {
    public Spin(String naam, double prijs, int kaartjes, double omzet, int oppervlakte, int aantalKeerGedraait, final int draaiLimiet) {
        super(naam, prijs, kaartjes, omzet, oppervlakte, aantalKeerGedraait, draaiLimiet);
    }
    public void kansSpelBelastingBetalen() {
        if (attractieOmzet > 0) {
            System.out.println("er is " + roundToTwoDecimals(attractieOmzet * 0.3) + " euro betaald over de omzet van " + attractieNaam);
            attractieOmzet -= roundToTwoDecimals(attractieOmzet * 0.3);
        } else {
            System.out.println(attractieNaam + " heeft geen omzet gemaakt");
        }
    }
    public double roundToTwoDecimals(double i) {
        return Math.round(i * 100.0)/100.0;
    }
}