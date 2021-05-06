package acwing.acwing3483;

import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(true){
            int n = sc.nextInt();
            System.out.println(dfs(n));
        }

    }
    static String dfs(int n){
        String res = "";
        for(int i = 14; i >= 0; i--){
            if(((n >> i) & 1) == 1){
                if(res != "") res += "+";
                if(i == 0) res += "2(0)";
                else if(i == 1) res += "2";
                else res += ("2(" +dfs(i) + ")");
            }
        }
        return res;
    }
}