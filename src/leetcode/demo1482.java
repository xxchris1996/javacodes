package leetcode;

public class demo1482 {
    public static int minDays(int[] bloomDay, int m, int k) {
        if(m * k > bloomDay.length) return -1;
        int left = 0;
        int right = getMax(bloomDay);
        while(left < right){
            int mid = left + (right - left)/2;
            if(check(mid, bloomDay, m, k)) right = mid;
            else left = mid + 1;
        }
        return left;
    }
    static int getMax(int[] bloomDay){
        int max = 0;
        for(int i : bloomDay){
            max = Math.max(max, i);
        }
        return max;
    }
    static boolean check(int day, int[] bloomDay, int m, int k){
        int canFlower = 0;
        int len = bloomDay.length;
        int cnt = 0;
        for(int i = 0; i < len; i++){
            if(bloomDay[i] <= day){
                cnt++;
            }else{
                cnt = 0;
            }
            if(cnt == k){
                canFlower++;
                cnt = 0;
            }
        }
        return canFlower >= m;
    }

    public static void main(String[] args) {
        int[] bloomDay = new int[]{1,10,3,10,2};
        int m = 3;
        int k = 1;
        int i = minDays(bloomDay, m, k);
        System.out.println(i);
    }
}
