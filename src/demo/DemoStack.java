package demo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class DemoStack {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> hasMap = new HashMap<>();
        int[] result = new int[nums1.length];
        for(int num : nums2){
            while(!stack.isEmpty() && stack.peek() < num){
                hasMap.put(stack.pop(),num);
            }
            stack.push(num);
        }
        for (int i = 0; i < nums1.length; i++) result[i] = hasMap.getOrDefault(nums1[i],-1);
        return result;
    }

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] ret = new int[temperatures.length];
        for (int i = 0; i <temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                int idx = stack.pop();
                ret[idx] = i - idx;
            }
            stack.push(i);
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{4,1,2};
        int[] nums2 = new int[]{1,3,4,2};
        DemoStack demoStack = new DemoStack();
        int[] result = demoStack.nextGreaterElement(nums1, nums2);
        System.out.println(Arrays.toString(result));
        int[] result1 = demoStack.dailyTemperatures(nums2);
        System.out.println(Arrays.toString(result1));
    }
}
