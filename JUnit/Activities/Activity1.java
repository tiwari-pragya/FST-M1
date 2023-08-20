package TestSuite;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Activity1 {

    static ArrayList<String> list;

    @BeforeAll
    public static void setUp(){

        //initialise and add values
        list  = new ArrayList<String>();

        list.add("alpha");
        list.add("beta");
    }

    @Test
    public void ainsertTest(){

        //check if size of list is 2
        assertEquals(2, list.size(), "Wrong size");

        //add new value and check new size of array is 3
        list.add("gamma");
        assertEquals(3, list.size(), "Wrong size");

        //check each value
        assertEquals("alpha", list.get(0), "Wrong element");
        assertEquals("beta", list.get(1), "Wrong element");
        assertEquals("gamma", list.get(2), "Wrong element");
    }

    @Test
    public void replaceTest(){

        //set value at index 1
        list.set(1,"delta");

        //assert elements
        assertEquals("alpha", list.get(0), "Wrong element");
        assertEquals("delta", list.get(1), "Wrong element");
        //assertEquals("gamma", list.get(2), "Wrong element");

    }
}
