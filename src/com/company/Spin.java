package com.company;

public class Spin extends RisicoRijkeAttracties implements Attractie.GokAttractie {
    public Spin(String naam, double prijs, int kaartjes, double omzet, int oppervlakte, int aantalKeerGedraait, final int draaiLimiet) {
        super(naam, prijs, kaartjes, omzet, oppervlakte, aantalKeerGedraait, draaiLimiet);
    }
    public void kansSpelBelastingBetalen() {
        Kassa.teBetalenBelasting += (attractiePrijs * 0.3);
        attractieOmzet += (attractiePrijs - (attractiePrijs * 0.3));
    }
}