package leetcode;

import java.lang.management.MemoryType;

public class demo1004 {
    public static int longestOnes(int[] nums, int k) {
        int l = 0, r = 0;
        int ans = 0;
        while(r < nums.length){
            if(nums[r] == 0) k--;
            while(k < 0){
                if(nums[l] == 0) k++;
                l++;
            }
            ans = Math.max(ans, r-l+1);
            r++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
        int res = longestOnes(nums,2);
        System.out.println(res);
    }
}
