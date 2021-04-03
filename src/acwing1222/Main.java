package acwing1222;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int n = s.length();
        int[][] dp = new int[n+1][n+1];
        for(int i = n - 2; i >= 0; i--){
            for(int j = i + 1; j < n; j++){
                if(s.charAt(i) == s.charAt(j)) dp[i][j] = dp[i+1][j-1];
                else dp[i][j] = Math.min(dp[i+1][j], dp[i][j-1]) + 1;
            }
        }
        System.out.println(dp[0][n-1]);

    }
}
