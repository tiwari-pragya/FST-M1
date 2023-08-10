package Activities;

import java.util.HashSet;

public class Activity10 {

    public static void main(String[] args){

        //create new Hashset
        HashSet<String> newSet = new HashSet<String>();

        //add elements
        newSet.add("Apple");
        newSet.add("Orange");
        newSet.add("Grapes");
        newSet.add("Guava");
        newSet.add("Mango");
        newSet.add("Watermelon");

        //print size of hashset
        System.out.println("Size of hashset: " + newSet.size());

        //remove an element
        System.out.println("Removed Mango from Set: " + newSet.remove("Mango"));

        //remove an element that is not present in hashset
        if(newSet.remove("Pineapple")) {
            System.out.println("Pineapple is removed from the Set");
        } else {
            System.out.println("Pineapple is not present in the Set");
        }

        //check if an item is in set
        System.out.println("Guava present in set: " + newSet.contains("Guava"));
        System.out.println("Pineapple present in set: " + newSet.contains("Pineapple"));

        //print updated set
        System.out.println("Updated set: " + newSet.toString());
    }
}
