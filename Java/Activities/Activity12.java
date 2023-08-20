package Activities;

interface Addable{
    int add(int num1, int num2);
}
public class Activity12 {

    public static void main(String[] args){

        //lambda expression(without body)
        Addable ad1 = (num1,num2) -> num1 + num2;
        System.out.println(ad1.add(5, 10));

        // lambda function(with body)
        Addable ad2 = (int num1, int num2) -> {
            return (num1 + num2);
        };
        System.out.println(ad2.add(10, 50));




    }
}
