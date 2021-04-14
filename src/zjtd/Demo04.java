package zjtd;

import java.util.*;

public class Demo04 {
    public int slidingPuzzle(int[][] board) {
        if(board.length == 0) return -1;
        int m = 4, n = 4;
        char[] chars = new char[16];
        int index = 0;
        for (int[] row : board) {
            for (int ch : row) {
                chars[index++] = (char)(ch+'a'-1);
            }
        }
        String start = new String(chars);
        String target = "abcdefghijklmn``";
        int[][] neighbour = new int[][]{{1,4},{0,2,5},{1,3,6},{2,7},
                {0,5,8},{1,4,6,9},{2,5,7,10},{3,6,11},
                {4,9,12},{5,8,10,13},{6,9,11,14},{7,10,15},
                {8,13},{9,12,14},{10,13,15},{11,14}};
        Queue<String> p = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        p.offer(start);
        visited.add(start);
        int step = 0;
        while(!p.isEmpty()){
            int size = p.size();
            for(int i = 0; i < size; i++){
                String cur = p.poll();
                if(target.equals(cur))  return step;
                int idx1 = cur.indexOf('`');
                int idx2 = cur.lastIndexOf('`');
                for(int adj : neighbour[idx1]){
                    String s = swap(cur, idx1, adj);
                    if(!visited.contains(s)){
                        p.offer(s);
                        visited.add(s);
                    }
                }
                for(int adj : neighbour[idx2]){
                    String s = swap(cur, idx2, adj);
                    if(!visited.contains(s)){
                        p.offer(s);
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
        int[][] board = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,0,0}};
        int[][] board1 = new int[][]{{1,0,2,4},{5,7,3,8},{9,6,10,12},{13,14,0,11}};
//        int[][] board1 = new int[][]{{1,2,3},{4,5,0}};
        Demo04 demo = new Demo04();
        int i = demo.slidingPuzzle(board);
        System.out.println(i);
    }
}
