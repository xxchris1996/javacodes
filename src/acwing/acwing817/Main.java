package acwing.acwing817;

import demo.Array;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }
        if(n == 1) System.out.println(n);
        Arrays.sort(nums);
        int slow = 1, fast = 1;
        while(fast < n){
            if(nums[slow - 1] != nums[fast]){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        System.out.println(slow);
    }
}
