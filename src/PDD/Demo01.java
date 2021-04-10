package PDD;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Demo01 {
    public static void main(String[] args) {
        while(true){
            Scanner sc = new Scanner(System.in);
            int len = sc.nextInt();
            int[] nums = new int[len];
            for (int i = 0; i < len; i++) {
                nums[i] = sc.nextInt();
            }
            Deque<Integer> stack = new LinkedList<>();
            stack.push(nums[0]);
            int res = 0;
            for (int i = 0; i < len; i++) {
                if (stack.isEmpty() || stack.peek() < nums[i]) {
                    stack.push(nums[i]);
                } else {
                    if (stack.size() == 1) {
                        stack.pop();
                        i--;
                        continue;
                    }
                    while (i < len && nums[i] < stack.peek()) {
                        stack.push(nums[i]);
                        i++;
                    }
                    res = Math.max(stack.size(), res);
                    i -= 2;
                    stack.clear();
                }
            }
            System.out.println(res);
        }
    }
}
