package com.company;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class TestHashMap {
    HashMap<Integer, Student> leerlingenDatabase = new HashMap<Integer, Student>();

    public TestHashMap() {


    }

    public void loadLeerling() {
        try {
            FileInputStream fis = new FileInputStream("src/com/company/File");
            ObjectInputStream ois = new ObjectInputStream(fis);

            leerlingenDatabase = (HashMap) ois.readObject();

            ois.close();
            fis.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
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

    public void saveFileLeerling() {
        try {
            FileOutputStream fos = new FileOutputStream("src/com/company/File");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this.leerlingenDatabase);
            oos.close();
            fos.close();
        } catch (IOException ioe) {
            {
                ioe.printStackTrace();
            }
        }
    }
}