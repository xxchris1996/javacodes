package demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DemoCollection {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};
        int n = arr.length;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            list.add(i);
        }
        Collections.reverse(list);
        Collections.reverse(Arrays.asList(arr));
//        for(int i = 0; i < n; i++){
//            System.out.println(arr[i]);
//        }
        for (Integer integer : list) {
            System.out.println(integer);
        }

    }
}
