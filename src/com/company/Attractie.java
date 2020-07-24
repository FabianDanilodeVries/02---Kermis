package com.company;

public class Attractie {
    String attractieNaam;
    double attractiePrijs;
    int aantalKaartjes;
    double attractieOmzet;
    int attractieOppervlakte;

    public Attractie(String naam, double prijs, int kaartjes, double omzet, int oppervlakte) {
        attractieNaam = naam;
        attractiePrijs = prijs;
        aantalKaartjes = kaartjes;
        attractieOmzet = omzet;
        attractieOppervlakte = oppervlakte;
    }
    interface GokAttractie {
        void kansSpelBelastingBetalen();
        double roundToTwoDecimals(double i);
    }
}
