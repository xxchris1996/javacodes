package SortAlgorithms;

import java.util.Arrays;

public class insertionSort {
    static void insertionSort(int[] arr){
        int n = arr.length;
        int preIndex, current;
        for(int i = 1; i < n; i++){
            preIndex = i-1;
            current = arr[i];
            while(preIndex >= 0 && arr[preIndex] > current){
                arr[preIndex+1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex+1] = current;
        }
    }
    public static void main(String[] args) {
        int[] arr = new int[]{6, 1, 2, 5, 9, 3, 4, 7, 10, 8};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
