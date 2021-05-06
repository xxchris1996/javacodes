package acwing.acwing435;

import java.util.*;
public class Main{
    static List<List<Integer>> res = new ArrayList<>();
    static List<Integer> list = new ArrayList<>();
    static int ans = 0;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int ans = method(n,m);
        System.out.println(ans);
        System.out.println(res);
    }
    static int method(int n, int m){
        dfs(0, 0, n, m);
        return ans;
    }

    static void dfs(int startn, int startm, int n, int m){
        list.add(startn);
//        if(startn == 0 && list.size() == m + 1){
        if(list.get(list.size() - 1) == 0 && list.size() == m + 1){
            ans++;
            res.add(new ArrayList<>(list));
            return;
        }
        if(startm > m) return;
//        list.add(startn);
        dfs((startn + 1)%n, startm + 1, n, m);
        list.remove(list.size()-1);
//        list.add(startn);
        dfs((startn + n - 1)%n, startm + 1, n, m);
        list.remove(list.size()-1);
    }
}