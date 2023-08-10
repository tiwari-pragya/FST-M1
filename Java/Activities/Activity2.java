package Activities;

import java.util.Arrays;

public class Activity2 {

    public static void main(String[] args){
        int[] arr = {10,77,10,54,-11,10};
        int totalSum = 30;

        System.out.println("Values of array: " + Arrays.toString(arr));
        System.out.println(checkSum(arr, totalSum));
    }

    //to check sum of the num in array is equal to totalsum given
    public  static Boolean checkSum(int[] num, int totalSum){
        int sum = 0;
        for(int i=0; i<num.length; i++){
            if(num[i] == 10){
                sum = sum + num[i];
            }
        }
        System.out.println("Sum of 10's in array: " + sum);
        return sum == totalSum;
    }
}
