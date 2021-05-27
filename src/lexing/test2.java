package lexing;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =  sc.nextInt();
        int[] nums = new int[n];
        for (int i=0; i<n; i++)
        {
            nums[i] = sc.nextInt();
        }
        Deque<Integer> q = new LinkedList<>();
        Deque<Integer> q2 = new LinkedList<>();
        q.push(nums[0]);
        int res = 0;
        for (int i=1; i<n; i++)
        {
            if (q.isEmpty()){
                q.push(nums[i]);
//                if(i == n-1) res++;
            }
            else {
                res++;
                if (q.peek() == nums[i])
                {
                    q.push(nums[i]);
                }else
                {
                    q2.push(q.pop());
                }
            }
        }
        System.out.println(q2.size());
        System.out.println(res);

    }
}
