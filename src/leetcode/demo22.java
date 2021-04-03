package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class demo22 {
        List<String> res = new ArrayList<>();
        public List<String> generateParenthesis(int n) {
            StringBuilder track = new StringBuilder();
            if(n == 0) return new ArrayList<>();
            backtrack(n, n, track);
            return res;
        }
        void backtrack(int left, int right, StringBuilder track){
            if(left > right) return;
            if(left < 0 || right < 0) return;
            if(left == 0 && right == 0){
                res.add(track.toString());
                return;
            }
//            System.out.println(track.toString());
            track.append("(");
            backtrack(left-1, right, track);
            track.deleteCharAt(track.length()-1);

            track.append(")");
            backtrack(left, right-1,track);
            track.deleteCharAt(track.length()-1);
        }

    public static void main(String[] args) {
        demo22 demomain = new demo22();
        List<String> strings = demomain.generateParenthesis(2);
        System.out.println(strings);

    }
}
