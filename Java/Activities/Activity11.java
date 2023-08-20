package Activities;

import java.util.HashMap;

public class Activity11 {

    public static void main(String[] args){

        //creating hashmap
        HashMap<Integer, String> colours = new HashMap<Integer, String>();

        //add data to hashmap
        colours.put(1, "Red");
        colours.put(2, "Green");
        colours.put(3, "Yellow");
        colours.put(4, "Purple");
        colours.put(5, "Black");

        System.out.println(colours.entrySet());

        //remove item
        System.out.println("Colour black removed from map: " + colours.remove(5));
        System.out.println("Map after removing colour Black: " + colours.entrySet());

        //check if colour exists in map
        System.out.println("Green Colour present in map: " + colours.containsValue("Green"));

        //size of map
        System.out.println("Size of map: " + colours.size());

    }
}
