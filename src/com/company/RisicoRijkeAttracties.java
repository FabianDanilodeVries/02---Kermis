package com.company;

abstract class RisicoRijkeAttracties extends Attractie{
    int aantalKeerGedraait;
    final int draaiLimiet;
    public RisicoRijkeAttracties(String naam, double prijs, int kaartjes, double omzet, int oppervlakte, int aantalKeerGedraait, final int draaiLimiet) {
        super(naam, prijs, kaartjes, omzet, oppervlakte);
        this.aantalKeerGedraait = aantalKeerGedraait;
        this.draaiLimiet = draaiLimiet;
    }
    void opstellingsKeuring(){
        if (aantalKeerGedraait == draaiLimiet) {
            System.out.println(attractieNaam + " is gekeurd en kan weer draaien");
            aantalKeerGedraait = 0;
        } else {
            System.out.println(attractieNaam + " heeft maar " + aantalKeerGedraait + " keer gedraait en hoeft nog niet gekeurd te worden");
        }
    }
}