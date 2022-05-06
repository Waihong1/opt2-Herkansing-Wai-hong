package com.company;
import java.io.Serializable;

import java.util.ArrayList;

public class Student implements Serializable {
    public int studentCode;
    public String naam;
    public String vakken;
    public String gehaald;
    public ArrayList <ExamenMakenLeerlingen>  examenMakenLeerlingenArrayList = new ArrayList<ExamenMakenLeerlingen>();


public Student(String naam,int studentCode){
    this.naam= naam;
    this.studentCode=studentCode;

    }

    public void getInfo (){
    System.out.println(studentCode + " " + naam);
    }



    public boolean loginStudent(int studentNaam) {
        return studentCode == studentNaam;


    }


}
