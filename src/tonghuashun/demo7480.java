package tonghuashun;

import java.util.HashMap;
import java.util.Scanner;

public class demo7480 {
    public static void main(String[] args) {
        HashMap<Character, Integer> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();//ac
        String s2 = sc.next();//abc
        boolean flag = true;
        for(int i = 0; i < s2.length(); i++){
            map.put(s2.charAt(i), map.getOrDefault(s2.charAt(i), 0) + 1);
        }
        for(int i = 0; i < s1.length(); i++){
            map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0) - 1);
            if(map.get(s1.charAt(i)) < 0) {
                flag = false;
                break;
            }
        }
        if(flag == true) System.out.println("true");
    }
}
