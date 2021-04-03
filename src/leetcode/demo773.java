package leetcode;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class demo773 {
    public int slidingPuzzle(int[][] board) {
        if(board.length == 0) return -1;
        int m = 2, n = 3;
//        StringBuilder begin = new StringBuilder();
//        for(int i = 0 ; i < 2; i++){
//            for(int j = 0; j < 3; j++){
//                begin.append(board[i][j]);
//            }
//        }
//        String start = begin.toString();
        char[] chars = new char[6];
        int index = 0;
        for (int[] row : board) {
            for (int ch : row) {
                chars[index++] = (char)(ch+'0');
            }
        }
        String start = new String(chars);
        String target = "123450";
        int[][] neighbour = new int[][]{{1,3},{0,4,2},{1,5},{0,4},{3,1,5},{4,2}};
        Deque<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.push(start);
        visited.add(start);
        int step = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                String cur = q.pop();
                if(target.equals(cur))  return step;
                int idx = cur.indexOf('0');
                for(int adj : neighbour[idx]){
                    String s = swap(cur, idx, adj);
                    if(!visited.contains(s)){
                        q.push(s);
                        visited.add(s);
                    }
                }
            }
            step++;
        }
        return -1;
    }
    String swap(String s, int idx, int adj){
        char[] chars = s.toCharArray();
        char tmp = chars[idx];
        chars[idx] = chars[adj];
        chars[adj] = tmp;
        return new String(chars);
    }

    public static void main(String[] args) {
        demo773 demo = new demo773();
        int[][] board = new int[][]{{1,2,3},{5,4,0}};
        int i = demo.slidingPuzzle(board);
        System.out.println(i);
    }
}
