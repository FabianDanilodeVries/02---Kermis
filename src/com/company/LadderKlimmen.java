package com.company;

public class LadderKlimmen extends Attractie implements Attractie.GokAttractie {
    public LadderKlimmen(String naam, double prijs, int kaartjes, double omzet, int oppervlakte) {
        super(naam, prijs, kaartjes, omzet, oppervlakte);
    }
    public void kansSpelBelastingBetalen() {
        Kassa.teBetalenBelasting += (attractiePrijs * 0.3);
        attractieOmzet += (attractiePrijs - (attractiePrijs * 0.3));
    }
}