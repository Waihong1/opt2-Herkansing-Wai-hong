import com.company.Examen;
import com.company.Leraar;
import com.company.Student;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TestAlleFuncties {
@Test
    public void testFunctie2()
    {
        HashMap<Integer, Student> leerlingenDatabase = new HashMap<Integer, Student>();
        HashMap<Integer, Examen> examenDatabase = new HashMap<Integer, Examen>();

        Student temp1 = new Student("Janneke", 1);
        leerlingenDatabase.put(1,temp1);

        for (Map.Entry<Integer, Student> set :
                leerlingenDatabase.entrySet()) {


            System.out.println(set.getKey() + " = "
                    + set.getValue());

            for (Object temp2 : leerlingenDatabase.keySet()) {
                System.out.println(temp2);
                System.out.println(leerlingenDatabase.get(temp2));
                Assert.assertEquals(1, temp2 );

            }
        }


    }
@Test
public  void testFunctie3(){
    HashMap<Integer, Leraar> lerarenDatabase = new HashMap<Integer, Leraar>();
    Leraar temp1 = new Leraar(2, "bas" );
    lerarenDatabase.put(2,temp1);
    for (Map.Entry<Integer, Leraar> set :
            lerarenDatabase.entrySet()) {

        System.out.println(set.getKey() + " = "
                + set.getValue());
        for (Object temp2 : lerarenDatabase.keySet()) {
            System.out.println(temp2);
            System.out.println(lerarenDatabase.get(temp2));
            Assert.assertEquals(2, temp2 );

        }



    }


    }
}



