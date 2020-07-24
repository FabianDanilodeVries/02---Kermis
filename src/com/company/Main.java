package com.company;

public class Main {
    public static void main(String[] args) {
        new Main().programmabedienen();
    }
    void programmabedienen() {
        Kassa kassa = new Kassa();
        kassa.starten();
    }
}