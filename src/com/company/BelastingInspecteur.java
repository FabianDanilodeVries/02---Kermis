package com.company;

public class BelastingInspecteur {
    double opgehaaldeBelasting;
    int belastingsInspectie;
    public BelastingInspecteur(double opgehaaldeBelasting, int belastingsInspectie) {
        this.opgehaaldeBelasting = opgehaaldeBelasting;
        this.belastingsInspectie = belastingsInspectie;
    }
    void belastingOphalen() {
        if (Kassa.teBetalenBelasting > 0) {
            opgehaaldeBelasting += roundToTwoDecimals(Kassa.teBetalenBelasting);
            belastingsInspectie++;
            System.out.println("De belastings inspecteur heeft " + roundToTwoDecimals(Kassa.teBetalenBelasting) + " aan belasting opgehaald.");
            System.out.println("In totaal heeft het circus " + roundToTwoDecimals(opgehaaldeBelasting) + " euro aan belasting betaald over " + belastingsInspectie + ((belastingsInspectie == 1) ? " inspectie." : " inspecties"));
            Kassa.teBetalenBelasting = 0;
        } else {
            System.out.println("Er hoeft nog geen belasting te worden betaald.");
        }
    }
    public double roundToTwoDecimals(double i) {
        return Math.round(i * 100.0)/100.0;
    }
}
