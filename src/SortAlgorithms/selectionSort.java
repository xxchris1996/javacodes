package SortAlgorithms;

import java.util.Arrays;

public class selectionSort {
    static void selectionSort(int[] arr){
        int n = arr.length;
        int minIndex, tmp;
        for(int i = 0; i < n; i++){
            minIndex = i;
            for (int j = i+1; j < n; j++){
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            tmp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{6, 1, 2, 5, 9, 3, 4, 7, 10, 8};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}