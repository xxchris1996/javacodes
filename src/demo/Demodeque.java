package demo;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Demodeque {
    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();
        deque.addLast(1);
        deque.addFirst(2);
        deque.add(3);
        Queue<Integer> queue = new ArrayDeque<>();

    }
}
