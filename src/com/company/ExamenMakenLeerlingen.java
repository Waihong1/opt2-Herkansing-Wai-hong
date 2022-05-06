package com.company;

import java.util.ArrayList;
import java.util.Collections;

    public class ExamenMakenLeerlingen {
        ArrayList<Examen.vragen> vragen = new ArrayList<Examen.vragen>();

        public ExamenMakenLeerlingen(ArrayList <Examen.vragen> V) {
            int sizevragen = V.size();
            ArrayList<Integer> Shuffle = new ArrayList<Integer>(sizevragen);
            for (int i = 0; i < sizevragen; i++) {
                Shuffle.add(i);
            }
            Collections.shuffle(Shuffle);
            for (int i = 0; i < 3; i++) {
                int nummer = Shuffle.get(i);
                Examen.vragen temp = V.get(nummer);
                this.vragen.add(temp);

            }
        }

        public  void printUitInfo(){
            for(Examen.vragen  i: vragen){
               System.out.println(i.vraag + i.antwoord);

            }


        }
    }

