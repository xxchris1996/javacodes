package Huawei;

import java.util.PriorityQueue;
import java.util.Scanner;

public class demo2021616_01 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        String[] strs = new String[n];
//        for(int i = 0; i < n; i++){
//            strs[i] = sc.nextLine();
//        }
//        String suffix = sc.next();
//        PriorityQueue<String> pq = new PriorityQueue<>();
//        for (String str : strs) {
//            String[] s = str.split(" ");
//            if(s[s.length-1] == suffix);
//        }

        Thread t = new Thread(){
            @Override
            public void run() {
                bigo();
            }
        };
        t.run();
        System.out.println("er");
    }
    static int mod = (int) (1e9-7);
    double fast(int x, int n){
        int res = 1;
        while(n != 0){
            if(n % 2 == 1) res = x * res % mod;
            n = n/2;
            x = x * x % mod;
        }
        return res;

    }
    static void bigo(){
        System.out.println("bigo");
    }
}
