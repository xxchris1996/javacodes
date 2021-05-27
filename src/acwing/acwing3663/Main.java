package acwing.acwing3663;

import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = n;
        for(int i = 0; i <= 2 * n + 1; i++){
            for(int j = 0; j < Math.abs(t); j++){
                System.out.print("  ");
            }
            for(int j = 0; j <= n - Math.abs(t); j++){
                System.out.print(j + " ");
            }
            for(int j = n - Math.abs(t) - 1; j >= 0; j--){
                System.out.print(j + " ");
            }
            t--;
            if (i == 2 * n + 1) break;
            System.out.println();
        }
    }
}