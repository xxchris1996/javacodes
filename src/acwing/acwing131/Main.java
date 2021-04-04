package acwing.acwing131;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public void largestRectangleArea(int[] heights){
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear();
        for(int i = n - 1; i >= 0; i--){
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        int ans = 0;
        for(int i = 0; i < n; i++){
            ans = Math.max(ans, heights[i] * (right[i]-left[i]-1));
        }
        System.out.println(ans);
//        return ans;
    }

    public static void main(String[] args) {
        Main demo = new Main();
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int num = sc.nextInt();
            if(num == 0) return;
            int[] arr = new int[num];
            for(int i = 0; i < num; i++){
                arr[i] = sc.nextInt();
            }
//            System.out.println("num:"+num);
//            System.out.println(Arrays.toString(arr));
            demo.largestRectangleArea(arr);
        }
    }
}
