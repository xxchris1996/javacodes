package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class demo74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0;
        if(n < matrix[0][0] || n > matrix[m-1][n-1]) return false;
        for(int i = 0; i < m; i++){
            if(matrix[i][0] <= target) row = i;
        }
        for(int j = 0; j < n; j++){
            if(matrix[row][j] == target) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[1][2];
        matrix[0][0] = 1;
        matrix[0][1] = 1;
        System.out.println(Arrays.toString(matrix[0]));
        int target = 1;
        demo74 demo = new demo74();
        boolean b = demo.searchMatrix(matrix, target);
        System.out.println(b);
    }

}
