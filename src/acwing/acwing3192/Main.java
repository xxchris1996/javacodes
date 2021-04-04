package acwing.acwing3192;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int nums = sc.nextInt();
        int maxValue = 0;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums; i++) {
            int num = sc.nextInt();
            hashMap.put(num, hashMap.getOrDefault(num, 0)+1);
        }
        Set<Map.Entry<Integer, Integer>> set = hashMap.entrySet();

        for (Map.Entry<Integer, Integer> integerIntegerEntry : set) {
            if(integerIntegerEntry.getValue() > maxValue){
                maxValue = integerIntegerEntry.getValue();
                ans = integerIntegerEntry.getKey();
            } else if(integerIntegerEntry.getValue() == maxValue){
                ans = Math.min(ans, integerIntegerEntry.getKey());
            }
        }
        System.out.println(hashMap);
        System.out.println(maxValue);
        System.out.println(ans);
    }
}
