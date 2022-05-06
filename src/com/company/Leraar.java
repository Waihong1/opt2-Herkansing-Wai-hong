package com.company;

import java.util.ArrayList;

public class Leraar {

    int leraarCode;
    String naam;
    ArrayList <Integer> lijstExamens = new ArrayList<Integer>();

    public Leraar (int leraarCode, String naam){
        this.leraarCode = leraarCode;
        this.naam = naam;
    }


public void printLeraarInfo(){
        System.out.println(leraarCode + " " +naam);

}

    public boolean login(int userNaam) {
        return leraarCode == userNaam;


    }


}
