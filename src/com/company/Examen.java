package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Examen {
    int examencode;
    String naam;
    String leraarNaam;
    ArrayList<Integer> ingeschrevenLeerling = new ArrayList<Integer>();
    ArrayList<vragen> vragenLijst = new ArrayList<vragen>();

    public class vragen {
        String vraag;
        int punten;
        String antwoord;

        public vragen(String vraag, String antwoord) {
            this.vraag = vraag;
            this.antwoord = antwoord;


        }
    }



    public void addVraag(String vraag, String antwoord) {
        vragen temp = new vragen(vraag, antwoord);
        vragenLijst.add(temp);

    }

    public Examen(int examencode, String naam, String leraarNaam) {
        this.examencode = examencode;
        this.naam = naam;
        this.leraarNaam = leraarNaam;

    }

    public void getExameninfo() {
        System.out.println(examencode + " " + naam + " " + leraarNaam);


    }

    public void printVragen() {
        for (vragen x : vragenLijst) {
            System.out.println(x.vraag);
            System.out.println(x.antwoord);
            System.out.println("\n");


        }
    }


    public ExamenMakenLeerlingen examenMakenLeerling() {
        ExamenMakenLeerlingen result = new ExamenMakenLeerlingen(vragenLijst);
        return result;
    }

}




