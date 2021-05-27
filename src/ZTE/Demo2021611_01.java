package ZTE;

import java.util.Scanner;

public class Demo2021611_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for(int i = 0; i < N; i++){
            nums[i] = sc.nextInt();
        }
        method(nums);
    }
    static void method(int[] nums){
        long sum = 0;
        int cnt = 0;
        int n = nums.length;
        int tmp = Integer.MIN_VALUE;
        for(int i = n - 1; i >= 0; i--){
            if(nums[i] > tmp) tmp = nums[i];
            if(nums[i] < tmp) cnt++;
            sum += tmp;
        }
        System.out.println(sum + " " + cnt);
    }
}
