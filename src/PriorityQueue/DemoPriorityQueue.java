package PriorityQueue;

import java.util.PriorityQueue;

public class DemoPriorityQueue {
    private static PriorityQueue<Integer> small;
    private static PriorityQueue<Integer> large;


    public static void main(String[] args) {
        small = new PriorityQueue<>((a, b) -> b.compareTo(a));
        large = new PriorityQueue<>((a, b) -> a.compareTo(b));
        for(int i = 10;i > 0; i--){
            small.offer(i);
            large.offer(i);
        }
        System.out.println(small);
        while(!large.isEmpty()) {
            Integer next = large.iterator().next();
            large.remove(next);
            System.out.println(next);
        }
    }
}
