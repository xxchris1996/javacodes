package demo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Array {
    public static void main(String[] args) {
//        int score = 100;
//        int[] newArray = new int[100];
//
//        int[] newArray1;
//        newArray1 = new int[]{1,2,3};
//        System.out.println(newArray1[1]);
//        System.out.println(Arrays.toString(newArray1));
        LinkedList<Integer> list1 = new LinkedList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        list1.add(6);
        System.out.println(list1);
        int i = list1.removeLast();
        System.out.println(list1);
    }
}   
