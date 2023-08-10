package Activities;


//interface 1
interface BicycleParts{
    public int gears = 0;
    public int speed = 0;
}

//interface 2
interface BicycleOperations{
    public void applyBrake(int decrement);
    public void speedUp(int increment);
}

//base class which implements interface 1 and 2
class Bicycle implements BicycleParts, BicycleOperations{

    int gears;
    int currentSpeed;

    //base class constructor
    Bicycle(int g,int cs){
        this.gears = g;
        this.currentSpeed = cs;
    }

    @Override
    public void applyBrake(int decrement) {
        currentSpeed = currentSpeed-decrement;
    }

    @Override
    public void speedUp(int increment) {
        currentSpeed = currentSpeed+increment;
    }

    public String bicycleDesc(){
        return("No of gears are "+ gears + "\nSpeed of bicycle is " + currentSpeed);
    }
}

//derived class that extends bicycle class
class MountainBike extends Bicycle{

    public int seatHeight;

    //derived class constructor
    MountainBike(int gears, int currentSpeed, int sh){
        super(gears, currentSpeed);
        seatHeight = sh;
    }

    public void setHeight(int h){
        seatHeight = h;
    }

    @Override
    public String bicycleDesc() {
        return "No of gears are "+ gears + "\nSpeed of bicycle is " + currentSpeed + "\nHeight of Bicycle is " + seatHeight;
    }
}

public class Activity7 {

    public static void main(String[] args){

        MountainBike mb = new MountainBike(3, 0, 25);
        System.out.println(mb.bicycleDesc());
        mb.speedUp(20);
        mb.applyBrake(5);
        System.out.println("New desc: " +mb.bicycleDesc());
    }
}
