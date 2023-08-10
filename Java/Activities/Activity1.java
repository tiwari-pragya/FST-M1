package Activities;

public class Activity1 {

    public static void main(String[] args){

        //object creation
        Car carName = new Car();

        //assign values
        carName.make = 2014;
        carName.color = "Black";
        carName.transmission = "Manual";

        //call methods of car class
        carName.displayCharacteristics();
        carName.accelerate();
        carName.brake();
    }
}

