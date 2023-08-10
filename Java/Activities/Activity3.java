package Activities;

public class Activity3 {
    public static void main(String[] args){

        double totalSec = 1000000000;
        double Earth = 31557600;
        double Mercury = 0.2408467 * Earth;
        double Venus = 0.61519726 * Earth;
        double Mars = 1.8808158 * Earth;
        double Jupiter = 11.862615 * Earth;
        double Saturn = 29.447498 * Earth;
        double Uranus = 84.016846 * Earth;
        double Neptune = 164.79132 * Earth;

        System.out.println("Age on Mercury: " + totalAge(totalSec, Mercury));
        System.out.println("Age on Venus: " + totalAge(totalSec, Venus));
        System.out.println("Age on Earth: " + totalAge(totalSec, Earth));
        System.out.println("Age on Mars: " + totalAge(totalSec, Mars));
        System.out.println("Age on Jupiter: " + totalAge(totalSec, Jupiter));
        System.out.println("Age on Saturn: " + totalAge(totalSec, Saturn));
        System.out.println("Age on Uranus: " + totalAge(totalSec, Uranus));
        System.out.println("Age on Neptune: " + totalAge(totalSec, Neptune));
    }

    public static double totalAge(double sec, double Planet){

        double age = 0;
        age = sec/Planet;
        return age;
    }
}
