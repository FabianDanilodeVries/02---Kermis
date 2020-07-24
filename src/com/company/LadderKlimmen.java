package com.company;

public class LadderKlimmen extends Attractie implements Attractie.GokAttractie {
    public LadderKlimmen(String naam, double prijs, int kaartjes, double omzet, int oppervlakte) {
        super(naam, prijs, kaartjes, omzet, oppervlakte);
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