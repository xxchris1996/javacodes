package acwing.acwing12;

import java.io.*;
import java.util.*;
/**
 * 技巧： 如果从需要求字典序最小， dp求解从后往前求
 * 即可从前往后推方案。
 * 求解出来dp[1][m]就是最大价值
 */
class Main{

    static BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
    static int N = 1010, V = 1010;
    static int[] w = new int[N], v = new int[N];
    static int[][] dp = new int[N][V];
    public static void main(String[] args) throws Exception{
        String[] ss = read.readLine().split(" ");
        int n = Integer.valueOf(ss[0]);
        int m = Integer.valueOf(ss[1]);
        for(int i = 1; i <= n; i++){
            ss = read.readLine().split(" ");
            v[i] = Integer.valueOf(ss[0]);
            w[i] = Integer.valueOf(ss[1]);
        }

        for(int i = n; i >= 1; i--){
            for(int j = 0; j <= m; j++){
                //不选
                dp[i][j] = dp[i + 1][j];
                if(j - v[i] >= 0){
                    //选
                    if(dp[i + 1][j -v[i]] + w[i] > dp[i][j]){
                        dp[i][j] = dp[i + 1][j -v[i]] + w[i];
                    }
                }
            }
        }
        List<Integer> list = new ArrayList();
        int curV = m; //当前最大体积
        for(int i = 1; i <= n; i++){
            //字典序最小，从小到大遍历，能选则选
            if(curV - v[i] >= 0 && dp[i][curV] == dp[i + 1][curV - v[i]] + w[i]){
                list.add(i);
                curV -= v[i];   //选了后，最大体积就要减少v[i];
            }
        }


        for(int i = 0; i < list.size(); i++){
            System.out.print(list.get(i) + " ");
        }
    }
}

