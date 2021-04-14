package jianzhiOffer;

import java.util.Arrays;

public class demo21 {
    public int[] exchange(int[] nums) {
        int pre = 0;
        int last = nums.length-1;
        while(pre < last){
            if(nums[pre] % 2 == 0 && nums[last] % 2 == 1){
                int tmp = nums[pre];
                nums[pre] = nums[last];
                nums[last] = tmp;
            }
            while (nums[pre] % 2 == 1) pre++;
            while (nums[last] % 2 == 0) last--;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        demo21 demo = new demo21();
        int[] exchange = demo.exchange(nums);
        System.out.println(Arrays.toString(exchange));
    }
}
