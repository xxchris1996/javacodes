package demo;

import java.util.PriorityQueue;

public class searchK {
    public static int findKth(int[] a, int n, int K) {
        // write code here
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < n; i++){
            pq.offer(a[i]);
            System.out.println(pq.toString());
            if(pq.size() > K) pq.poll();
        }
        for(int i : pq){
            System.out.println(i);
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] a = new int[]{10,10,9,9,8,7,5,6,4,3,4,2};
        int n = 12;
        int K = 3;
        findKth(a, n, K);
    }


}
