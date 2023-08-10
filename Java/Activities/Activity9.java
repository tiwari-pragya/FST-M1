package Activities;

import java.awt.*;
import java.util.ArrayList;

public class Activity9 {

    public static void main(String[] args){

        ArrayList<String> myList = new ArrayList<String>();
        myList.add("John");
        myList.add("Mark");
        myList.add("Kate");
        myList.add("Peter");
        myList.add("Sam");


        for(int i=0; i<myList.size(); i++){
            System.out.println("Name at index" + i +" is: " + myList.get(i));
        }

        //retrieve 3rd name in list
        System.out.println("Name at 3rd index is: " + myList.get(2));

        //to check if a name exists in the ArrayList
        System.out.println("Name Park present in arraylist: " + myList.contains("Park"));
        System.out.println("Name Peter present in arraylist: " + myList.contains("Peter"));

        //number of names in the ArrayList
        System.out.println("Size of arraylist: " + myList.size());

        //remove a name from the list and print the new size

        System.out.println("Name kate removed from list: " + myList.remove("Kate"));
        System.out.println("New Size of arraylist: " + myList.size());
    }

}
