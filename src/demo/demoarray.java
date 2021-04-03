package demo;

import java.util.Arrays;

public class demoarray {
    public static void main(String[] args) {
        int[][] arr = new int[6][];
            arr[0] = new int[]{1,3};
            arr[1] = new int[]{0,4,2};
            arr[2] = new int[]{1,5};
            arr[3] = new int[]{0,4};
            arr[4] = new int[]{3,1,5};
            arr[5] = new int[]{4,2};
        for (int[] ints : arr) {
            System.out.println(Arrays.toString(ints));
        }
        int[][] arrs = new int[][]{{1,3},{0,4,2},{1,5},{0,4},{3,1,5},{4,2}};
        for (int[] ints : arrs) {
            System.out.println(Arrays.toString(ints));
        }
    }

}
