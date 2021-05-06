package acwing.acwing3493;

import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
        int n = 3;
//        int k = sc.nextInt();
        int k = 1;
//        int[] num = new int[n];
        int[] num = new int[]{2,5,4};
//        int[] vis = new int[n];
        int[] vis = new int[]{0,0,1};
        int sta = 0;
//        for(int i = 0; i < n; i++){
//            num[i] = sc.nextInt();
//        }
        for(int i = 0; i < n; i++){
//            vis[i] = sc.nextInt();
            if(vis[i] == 1) sta += num[i];
        }
        int left = 0, right = k-1;
        int cur = 0;
        for(int i = 0; i < k; i++){
            if(vis[i] == 0) cur += num[i];
        }
        int max = cur;
        while(right < n-1){
            max = Math.max(max, cur);
            left++;
            right++;
            if(vis[left-1] == 0) cur -= num[left-1];
            if(vis[right] == 0) cur += num[right];
        }
        System.out.println(sta+max);
    }
}