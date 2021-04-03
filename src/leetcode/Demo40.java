package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, res, list, 0);
        return res;
    }
    void dfs(int[] candidates, int target, List<List<Integer>> res, List<Integer> list, int idx){
        if(target == 0){
            while(!res.contains(list)){res.add(new ArrayList<Integer>(list));}
            return;
        }
        if(idx == candidates.length||  target<0) return;

        dfs(candidates, target, res, list, idx+1);

        // if(target - candidates[idx] >= 0){
        list.add(candidates[idx]);
        dfs(candidates, target - candidates[idx], res, list, idx+1);
        list.remove(list.size()-1);

        // }
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{1,8};
        int target = 8;
        Demo40 demo = new Demo40();
        List<List<Integer>> lists = demo.combinationSum2(candidates, target);
        System.out.println(lists);
    }
}
