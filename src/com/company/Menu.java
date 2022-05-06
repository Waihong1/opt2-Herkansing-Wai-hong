package com.company;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Menu {
    HashMap<Integer, Leraar> lerarenDatabase = new HashMap<Integer, Leraar>();
    HashMap<Integer, Student> leerlingenDatabase = new HashMap<Integer, Student>();
    HashMap<Integer, Examen> examenDatabase = new HashMap<Integer, Examen>();
    Leraar loginLeraar;
    Student loginStudent;

    public Menu() {
       // Leraar temp = new Leraar(1, "Jan");
       // Student temp1 = new Student("Janneke", 1);
        //Examen temp2 = new Examen(1, "Geschiedenis", "Henk");
        //temp2.ingeschrevenLeerling.add(1);
        //this.lerarenDatabase.put(1, temp);
        //this.leerlingenDatabase.put(1, temp1);
        //this.examenDatabase.put(1, temp2);
        loadLeerling();

    }
public  void saveFileLeerling(){
    try
    {
        FileOutputStream fos = new FileOutputStream("src/com/company/File");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(this.leerlingenDatabase);
        oos.close();
        fos.close();
    }
    catch (IOException ioe){
        {
            ioe.printStackTrace();
        }
    }



}  public  void loadLeerling(){
        try
        {
            FileInputStream fis = new FileInputStream("src/com/company/File");
            ObjectInputStream ois = new ObjectInputStream(fis);

            leerlingenDatabase = (HashMap) ois.readObject();

            ois.close();
            fis.close();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
            return;
        }
        catch (ClassNotFoundException c)
        {
            System.out.println("Class not found");
            c.printStackTrace();
            return;
        }

        //Verify list data
        for (Map.Entry<Integer, Student> set :
                leerlingenDatabase.entrySet()) {

            // Printing all elements of a Map
            System.out.println(set.getKey() + " = "
                    + set.getValue().naam);
        }
    }
    public  void loadLeraar(){
        try
        {
            FileInputStream fis = new FileInputStream("src/com/company/File");
            ObjectInputStream ois = new ObjectInputStream(fis);

            lerarenDatabase = (HashMap) ois.readObject();

            ois.close();
            fis.close();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
            return;
        }
        catch (ClassNotFoundException c)
        {
            System.out.println("Class not found");
            c.printStackTrace();
            return;
        }

        //Verify list data
        for (Map.Entry<Integer, Leraar> set :
                lerarenDatabase.entrySet()) {

            // Printing all elements of a Map
            System.out.println(set.getKey() + " = "
                    + set.getValue().naam);
        }
    }




    public void mainEventLoop() {

        boolean escapeFlag = false;
        while (!escapeFlag) {

            System.out.println("ben je een leraar of Student");
            System.out.println("A) voor leraar\nB) voor Student\nC) Maak een student aan\nD) sluit programma ");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            switch (input) {
                case "A":
                    lerarenEventLoop();
                    break;
                case "B":
                    studentenEventLoop();
                    break;
                case "C":
                     Scanner scanner6 = new Scanner(System.in);
                     System.out.println("Wat is je naam");
                     String vulin = scanner6.nextLine();
                     System.out.println("Wat is je code");
                     int vulin2 = scanner6.nextInt();
                     Student b = new Student(vulin,vulin2);
                     leerlingenDatabase.put(vulin2,b);
                    saveFileLeerling();
                   System.out.println(leerlingenDatabase.size());
                   break;
                case "D":
                    escapeFlag = true;
                    System.out.println("Programma wordt gesloten.");
                    break;

                default:
                    System.out.println("optie bestaat niet, Geef door A of B\n");


            }

        }
    }

    public void lerarenEventLoop() {
        Leraar temp;
        Integer input;
        boolean loginFlag = false;
        Scanner scanner = new Scanner(System.in);
        while (!loginFlag) {
            System.out.println("Vul je lerarencode in");
            input = scanner.nextInt();
            if (this.lerarenDatabase.containsKey(input)) {
                temp = lerarenDatabase.get(input);
                if (temp.login(input)) {
                    loginFlag = true;
                    System.out.println("Welkom");
                    loginLeraar = temp;
                    temp.printLeraarInfo();

                } else {
                    System.out.println("Wachtwoord is verkeerd.");
                }

            } else {
                System.out.println("niet bestaande  Leraarcode");
            }

        }
        boolean inputFlag = false;
        while (!inputFlag) {
            System.out.println("\nwelke keuze wilt u:\n 1) maak examen aan\n 2) Lijst met studenten\n 3) Student verwijderen\n 4) lijst met examens\n 5) om weg te gaan");
            input = scanner.nextInt();
            switch (input) {
                case 1:
                    maakExamenaan();
                    Examen ab = examenDatabase.get(2);
                    ab.printVragen();

                    break;
                case 2:
                    printLeerlingen();
                    break;
                case 3:
                    printExamenuit();
                    schrijfUit();
                    break;
                case 4:
                    printExamenuit();
                    break;
                case 5:
                    inputFlag = true;
                    break;
                default:
                    System.out.println("Geen valide optie");
            }
        }


    }

    public void printLeerlingen() {
        System.out.println();
        for (HashMap.Entry<Integer, Student> set : leerlingenDatabase.entrySet()) {
            Student temp = set.getValue();
            temp.getInfo();


        }


    }

    public void maakExamenaan() {
        boolean nameFlag = false;
        Integer code = null;
        Scanner input = new Scanner(System.in);
        while (!nameFlag) {
            System.out.println("Vul examencode in");
            code = input.nextInt();
            if (examenDatabase.containsKey(code)) {
                System.out.print("Examencode bestaat al ,geef unieke examencode in.");
            } else {
                nameFlag = true;
            }
        }
        System.out.println("Geef vaknaam");
        Scanner test = new Scanner(System.in);
        String vak = test.nextLine();
        Examen tempExamen = new Examen(code, vak, loginLeraar.naam);
        examenDatabase.put(code, tempExamen);
        System.out.println("Examen met code " + code + " Voor het vak " + vak + " door leraar " + loginLeraar.naam);
        loginLeraar.lijstExamens.add(code);
        maakVragenAan(tempExamen);


    }

    public void printExamenuit() {
        System.out.println();
        for (HashMap.Entry<Integer, Examen> set : examenDatabase.entrySet()) {
            Examen temp = set.getValue();
            temp.getExameninfo();


        }
        //System.out.println("Deze examens heb ik gemaakt.");
        // for (Integer ex : loginLeraar.lijstExamens) {
        //    examenDatabase.get(ex).getExameninfo();


    }

    public void studentenEventLoop() {
        Student temp;
        Integer input;
        boolean loginFlag = false;

        Scanner scanner = new Scanner(System.in);
        while (!loginFlag) {
            System.out.println("Vul je Studentencode in");
            input = scanner.nextInt();
            if (this.leerlingenDatabase.containsKey(input)) {
                temp = leerlingenDatabase.get(input);
                if (temp.loginStudent(input)) {
                    loginFlag = true;
                    System.out.println("Welkom");
                    loginStudent = temp;
                    temp.getInfo();

                } else {
                    System.out.println("Wachtwoord is verkeerd.");
                }

            } else {
                System.out.println("niet bestaande  Leraarcode");
            }
        }
        boolean inputFlag = false;
        while (!inputFlag) {
            System.out.println("\nwelke keuze wilt u:\n 1) Examen maken\n 2) Selecteer examen dat je wilt inschrijven\n 3) \n 4) \n 5) om weg te gaan");
            input = scanner.nextInt();
            switch (input) {
                case 1:
                for ( ExamenMakenLeerlingen  x : loginStudent.examenMakenLeerlingenArrayList){
                    for (Examen.vragen y : x.vragen){
                        System.out.println(y.vraag);
                        Scanner scanner2 = new Scanner(System.in);
                        String antwoord2 = scanner2.nextLine();
                        if (antwoord2.equals(y.antwoord)){
                            System.out.println("Antwoord is correct");

                        }
                        else{
                            System.out.println("Antwoord is verkeerd");
                            System.out.println("De goede antwoord is: " + y.antwoord);

                        }

                    }

                }
                    break;
                case 3:

                    break;
                case 2:
                    printExamenuit();
                    Scanner input3 = new Scanner(System.in);
                    System.out.println("Vul de examencode in");
                    int input5 = input3.nextInt();
                    Examen temp3 = examenDatabase.get(input5);
                    temp3.ingeschrevenLeerling.add(loginStudent.studentCode);
                    ExamenMakenLeerlingen xc = temp3.examenMakenLeerling();
                    loginStudent.examenMakenLeerlingenArrayList.add(xc);


                    break;
                case 4:
                    break;
                case 5:
                    inputFlag = true;
                    break;
                default:
                    System.out.println("Geen valide optie");
            }
        }


    }


    public void schrijfUit() {
        Scanner input = new Scanner(System.in);
        boolean Flagger = false;
        Integer code = null;
        while (!Flagger) {
            System.out.println("Vul hier de code van de examen in waarvan  je de leerling  wilt uitschrijven");
            code = input.nextInt();
            if (examenDatabase.containsKey(code)) {
                //System.out.println("Je bent uitgeschreven voor deze vak met deze code " + code);
                Flagger = true;

            } else {
                System.out.println("Deze Examencode bestaat niet vul een bestaande examencode in.");

            }

        }
        Examen temp = examenDatabase.get(code);
        for (Integer i : temp.ingeschrevenLeerling) {
            leerlingenDatabase.get(i).getInfo();

        }
        verwijderStudent();


    }


    public void verwijderStudent() {
        boolean flagger = false;
        Scanner input = new Scanner(System.in);
        Integer code = null;
        while (!flagger) {
            System.out.println("Vul de studentcode in");
            code = input.nextInt();

            if (lerarenDatabase.containsKey(code)) {
                Student temp = leerlingenDatabase.get(code);
                System.out.println("De leerling met ." + code + "met deze naam is verwijdert " + temp.naam);
                leerlingenDatabase.remove(code);
                flagger = true;
            } else {
                System.out.println("Leerllingencode bestaat niet vul opnieuw in.");

            }


        }

    }

    public void maakVragenAan(Examen current) {
        Scanner scanner = new Scanner(System.in);
        boolean flag = false;
        while (!flag) {
            System.out.println("Vul een vraag in, zo niet voer in Q om weg te gaan");
            String input = scanner.nextLine();
            if (input.equals("Q")) {
                flag = true;
                System.out.println("ja het is Q");
            } else {
                //vragenDatabase.put(1, input);
                System.out.println("Vul ook een antwoord in");
                String antwoord = scanner.nextLine();
                //antwoordenDatabase.put(1, antwoord);
                System.out.println("Wil je nog een vraag maken? (Zo niet voer in Q (zo wel voer in J");
                String escapeOrAgain = scanner.nextLine();
                current.addVraag(input, antwoord);
                if (escapeOrAgain.equals("Q")) {
                    flag = true;

                }


            }
        }


    }


}
