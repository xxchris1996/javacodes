package jianzhiOffer;

import java.util.HashSet;
import java.util.Set;

public class demo48 {

    public static int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        Set<Character> set = new HashSet<>();
        int l = 0, r = 0;
        set.add(s.charAt(l));
        int ans = 1;
        while(r < s.length()-1){
            r++;
            if(!set.contains(s.charAt(r))){
                set.add(s.charAt(r));

            } else {
                while(s.charAt(l) != s.charAt(r) && l < r){
                    set.remove(s.charAt(l));
                    l++;
                }
                l++;
            }
            System.out.println(l + "l");
            System.out.println(r + "r");
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        int i = lengthOfLongestSubstring(s);
        System.out.println(i);
    }
}
