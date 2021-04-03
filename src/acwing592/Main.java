package acwing592;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0; i<t; i++)
        {
            int r = sc.nextInt();
            int c = sc.nextInt();
            int[][] height = new int[r][c];
            for(int j=0; j<r; j++)
            {
                for(int k=0; k<c; k++)
                {
                    height[j][k] = sc.nextInt();
                }
            }
            int res = findminpath(height, r, c);
            int num = i + 1;
            System.out.println("Case #" + num + ": " + res);
        }
    }
    public static int findminpath(int[][] height, int r, int c){
        int[][] path = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        boolean[][] use = new boolean[r][c];
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(i == 0 || j == 0 || i == r-1 || j == c-1){
                    pq.add(new int[]{height[i][j], i, j});
                }
            }
        }
        int maxVal = Integer.MIN_VALUE;
        int res = 0;
        while (!pq.isEmpty()){
            int[] tmp = pq.remove();
            int h = tmp[0];
            int row = tmp[1];
            int col  = tmp[2];
            maxVal = Math.max(maxVal, h);
            res += maxVal - h;
            use[row][col] = true;
            for(int k = 0; k < path.length; k++){
                int rownext = row + path[k][0];
                int colnext = col + path[k][1];
                if(rownext < 0 || colnext < 0 || rownext >= r || colnext >= c || use[rownext][colnext] == true){
                    continue;
                }
                use[rownext][colnext] = true;
                pq.add((new int[]{height[rownext][colnext], rownext, colnext}));
            }
        }
        return res;
    }
}
