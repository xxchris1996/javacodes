package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class demo781 {
        public int numRabbits(int[] answers) {
            int res = 0;
            int nums = answers.length;
            if(nums == 0) return res    ;
            HashMap<Integer, Integer> hasMap = new HashMap<>();
            for(int i = 0; i < nums; i++){
                hasMap.put(answers[i], hasMap.getOrDefault(answers[i], 0)+1);
            }
            System.out.println(hasMap);
            Set<Map.Entry<Integer, Integer>> entries = hasMap.entrySet();
            for (Map.Entry<Integer, Integer> entry : entries) {
                int n = entry.getKey();
                int m  = entry.getValue();
                int count = m / (n + 1);
                int mod = m %(n+1);
                if(mod != 0){
                    res = res + (count+1)*(n+1);
                } else  {
                    res += count * (n+1);
                }

            }
            
            return res;
        }

    public static void main(String[] args) {
        int[] answer = new int[]{10,10,10};
        demo781 demo = new demo781();
        int i = demo.numRabbits(answer);
        System.out.println(i);
    }
}
