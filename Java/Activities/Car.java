package Activities;

public class Car {

    String color;
    String transmission;
    int make;
    int tyres;
    int doors;

    //constructor
    Car(){
        tyres = 4;
        doors = 4;
    }

    //method to display characteristics
    public void displayCharacteristics(){
        System.out.println("Color of the car: " + color);
        System.out.println("Transmission of the car: " + transmission);
        System.out.println("Make of the car: " + make);
        System.out.println("Total Tyres in the car: " + tyres);
        System.out.println("Total Doors in the car: " + doors);
    }

    //print statements
    public void accelerate(){
        System.out.println("Car is moving forward");
    }

    public void brake(){
        System.out.println("Car has stopped");
    }
}
