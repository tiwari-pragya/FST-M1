package Activities;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Activity13 {
    public static void main(String[] args){

        //object creation
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<Integer>();
        Random indexGen = new Random();

        //add input to arraylist
        System.out.print("Enter integers please: " + "\n(Hint: Use non-int to terminate)");
        while (scan.hasNextInt()){
            list.add(scan.nextInt());
        }

        //convert arraylist to array
        Integer[] numlist = list.toArray(new Integer[0]);


        //generate index
        int rnum = indexGen.nextInt(numlist.length);

        //print value at the index generated
        System.out.println("Numbers present in Arraylist at index " + rnum + "is: " + numlist[rnum]);

        scan.close();
    }
}
