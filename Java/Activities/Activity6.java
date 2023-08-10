package Activities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

//class Plane
class Plane{
    private List<String> passengers;
    private int maxPassengers;
    private Date lastTimeTookOf;
    private Date lastTimeLanded;

    //constructor for plane
    Plane(int pnum){
        this.maxPassengers = pnum;
        this.passengers = new ArrayList<String>();

    }

    //methods in plane class
    public void onboard(String pName){
        this.passengers.add(pName);
    }
    public Date takeOff(){
        return new Date();
    }

    public void land(){
        this.lastTimeLanded = new Date();
        this.passengers.clear();
    }
    public Date getLastTimeLanded(){
        return lastTimeLanded;
    }
    public List<String> getPassesngers(){
        return passengers;
    }
}

public class Activity6 {
    public static void main(String[] args) throws InterruptedException {

        //object creation and setting value of maspassenger
        Plane p = new Plane(10);

        //add names to passengerlist
        String[] name = {"a","b","c","d","e","f","g","h","i","j"};
        for (int i=0; i<10; i++){
            p.onboard(name[i]);
        }

        //print takeoff time
        System.out.println("TakeOff Time: " + p.takeOff());

        //print passenger list
        System.out.println("Passenger Details: " + p.getPassesngers().toString());
        Thread.sleep(5000);

        //call land method
        p.land();

        //print land time
        System.out.println("Land Time: " + p.getLastTimeLanded());
    }
}
