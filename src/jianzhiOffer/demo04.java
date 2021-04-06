package jianzhiOffer;

public class demo04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        if(m == 0 || n == 0) return false;
        int col = 0, row = n - 1;
        while(col < m && row >= 0){
            if(matrix[row][col] == target) return true;
            else if(matrix[row][col] > target) col--;
            else row++;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        int target = 5;
        demo04 demo = new demo04();
        boolean b = demo.findNumberIn2DArray(matrix, target);
        System.out.println(b);
    }
}
