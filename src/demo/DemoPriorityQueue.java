package demo;

import java.util.PriorityQueue;

public class DemoPriorityQueue {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(((o1, o2) -> {
//            if( o1 > o2) return 1;
//            if( o1 < o2) return -1;
            return o2 - o1;
        }));
        int[] num = new int[]{1,2,5,3,7};
        for (int i : num) {
            queue.offer(i);
        }

        for (int i : num) {
            System.out.println(queue.poll());;
        }
    }
}
