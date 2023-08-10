package Activities;

import java.util.Arrays;

public class Activity4 {

    public static void main(String[] args){

        int[] data = {20,15,40,2,1,3};
        System.out.println("Unsorted Array: " + Arrays.toString(data));
        Sort(data);
        System.out.println("Sorted Array in Ascending Order: " + Arrays.toString(data));

    }

    //sort method
    public static void Sort(int[] arr){
        int[] sortedArray;

        for(int i=0; i<arr.length; i++){
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && key < arr[j]) {
                arr[j + 1] = arr[j];
                --j;
            }
            arr[j + 1] = key;
        }
    }
}
