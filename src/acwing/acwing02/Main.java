package acwing.acwing02;
import java.util.*;
public class Main{
    static int N = 1010;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int maxV = sc.nextInt();
        int[] v = new int[N];
        int[] w = new int[N];
        for(int i = 0; i < n; i++){
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }
        int[][] dp = new int[N][N];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= maxV; j++){
                dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-v[i-1]]+w[i-1]);
            }
        }
        System.out.println(dp[n-1][maxV-1]);
    }
}