package demo;

import java.util.LinkedList;

public class DemoString {
    public static void main(String[] args) {
        String str = "1,2,3,4,5,6,7";
        LinkedList<String> nodes = new LinkedList<>();
        LinkedList<String> nodes1 = new LinkedList<>();
        LinkedList<String> nodes2 = new LinkedList<>();
        for(String s :str.split(",")){
            nodes.add(s);
            nodes1.addLast(s);
            nodes2.addFirst(s);
        }
        System.out.println(nodes);
        System.out.println(nodes1);
        System.out.println(nodes2);
    }
}
