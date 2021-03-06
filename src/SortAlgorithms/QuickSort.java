package SortAlgorithms;

import java.util.Arrays;

public class QuickSort {
    static void quicksort(int n[], int left, int right) {
        int dp;
        if(left < right){
            dp = paitition(n, left, right);
            quicksort(n, left, dp - 1);
            quicksort(n, dp+1, right);
        }
    }

    static int paitition(int[] n, int left, int right){
        int pivot = n[left];
        while(left < right){
            while(left < right && n[right] > pivot){
                right--;
            }
            if(left < right){
                n[left] = n[right];
            }
            while(left < right && n[left] < pivot){
                left++;
            }
            if(left < right){
                n[right] = n[left];
            }
        }
        n[left] = pivot;
        return left;
    }



    public static void main(String[] args) {
        int[] n = new int[]{6, 1, 2, 5, 9, 3, 4, 7, 10, 8};
        quicksort(n,0, n.length - 1);
        System.out.println(Arrays.toString(n));
    }

}
