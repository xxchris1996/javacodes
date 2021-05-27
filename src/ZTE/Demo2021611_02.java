package ZTE;

import java.util.Scanner;

public class Demo2021611_02 {//kill the monster
    static int[] vis = new int[10];
    static int cnt = 10;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while((T--) != 0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] skills = new int[n][2];
            for(int i = 0; i < n; i++){
                skills[i][0] = sc.nextInt();
                skills[i][1] = sc.nextInt();
            }
            cnt = 10;
            dfs(0, m, n, skills);
            if (cnt == 10) System.out.println(-1);
            else System.out.println(cnt);
        }


    }

    private static void dfs(int i, int m, int n, int[][] skills) {
        if(m <= 0 && i < cnt){
            cnt = i;
            return;
        }
        if(i >= cnt) return;
        for(int j = 0; j < n; j++){
            if(vis[j] == 0){
                vis[j] = 1;
                int tmp = (m <= skills[j][1] ? m - 2 * skills[j][0] : m - skills[j][0]);
                dfs(i+1, tmp, n, skills);
                vis[j] = 0;
            }
        }
    }
}
