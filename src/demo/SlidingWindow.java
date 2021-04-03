package demo;

import java.util.*;

public class SlidingWindow {
    Map<Character, Integer> ori = new HashMap<>();
    Map<Character, Integer> cnt = new HashMap<>();
    public String minWindow(String s, String t){
        int tLen = t.length();
        for(int i = 0; i < tLen; i++){
            char c = t.charAt(i);
            ori.put(c, ori.getOrDefault(c,0)+1);
        }
        int l = 0, r = -1;
        int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
        int sLen = s.length();
        while (r < sLen){
            ++r;
            if( r < sLen && ori.containsKey(s.charAt(r))){
                cnt.put(s.charAt(r),cnt.getOrDefault(s.charAt(r),0)+1);
            }
            while (this.check() && l <= r){
                if(r - l + 1 < len){
                    len = r - l + 1;
                    ansL = l;
                    ansR = l + len;
                }
                if(ori.containsKey(s.charAt(l))){
                    cnt.put(s.charAt(l), cnt.getOrDefault(s.charAt(l),0)-1);
                }
                ++l;
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }

    public boolean check(){
        Iterator iter = ori.entrySet().iterator();
        while (iter.hasNext()){
            Map.Entry entry = (Map.Entry) iter.next();
            Character key = (Character) entry.getKey();
            Integer val = (Integer) entry.getValue();
            if(cnt.getOrDefault(key, 0) < val){
                return false;
            }
        }
        return true;
    }

    public int lengthOfLongestSubstring(String s){
        Set<Character> set = new HashSet<>();
        int n =s.length();
        if(n == 0) return 0;
        int res = 0, l = 0, r = 0;
        while(r < n){

            while (r < n && !set.contains(s.charAt(r))){
                set.add(s.charAt(r));
                r++;
            }
            if(r - l + 1> res) res = r - l +1;
            if(r < n && set.contains(s.charAt(r))){
                while (l < r && s.charAt(l) != s.charAt(r)){
                    set.remove(s.charAt(l));
                    l++;
                }
                set.remove(s.charAt(l));
                l++;
            }

//            set.remove(s.charAt(l));
        }
        return  res;
        // Set<Character> occ = new HashSet<Character>();
        // int n = s.length();
        // int rk = -1, ans = 0;
        // for (int i = 0; i < n; ++i){
        //     if (i!=0){
        //         occ.remove(s.charAt(i-1));
        //     }
        //     while(rk+1 < n && !occ.contains(s.charAt(rk+1))){
        //         occ.add(s.charAt(rk+1));
        //         ++rk;
        //     }
        //     ans = Math.max(ans,rk+1-i);
        // }
        // return ans;
    }

    public static void main(String[] args) {
        SlidingWindow slidingWindow = new SlidingWindow();
        String s = "abcabcbb";
        int i = slidingWindow.lengthOfLongestSubstring(s);
        System.out.println(i);
    }

}
