package acwing93;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nums = sc.nextInt();
        int size = sc.nextInt();
        int[] arr = new int[nums];
        for(int i = 0; i < nums; i++){
            arr[i] = i+1;
        }
//        System.out.println(Arrays.toString(arr));
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrack(arr, size, 0, res, list);
        for (List<Integer> re : res) {
            re.forEach(i->System.out.print(i + " "));
            System.out.println("");
        }
    }
    static void backtrack(int[] arr, int size, int start, List<List<Integer>> res, List<Integer> list){
        if(size <= 0) {
            res.add(new ArrayList<>(list));
            return;}
        for(int i = start; i < arr.length; i++){
            list.add(arr[i]);
            backtrack(arr, size-1, i+1, res, list);
            list.remove(list.size()-1);
        }

    }
}
