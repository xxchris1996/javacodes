package acwing.acwing1381;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int res = 1;
        int mod = 100000;
        while(N > 0){
            res = res * N;
            while(res % 10 == 0) res = res / 10;
            res %= mod;
            N--;
        }
        System.out.println(res%10);
    }
}
