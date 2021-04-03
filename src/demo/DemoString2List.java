package demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class DemoString2List {
    public static void main(String[] args) {
        int n = 8;
        char[][] chess = new char[n][n];
        for(char[] i : chess){
            Arrays.fill(i, '.');
        }
        for(char[] i : chess) {
            System.out.println(new String(i));
        }
        for(int i = 0; i < chess.length; i++){
            System.out.println(chess[i]);
        }
        List<String> res = new LinkedList<>();
        for (char[] i : chess){
            StringBuilder sb = new StringBuilder();
            for(char j : i){
                sb.append(j);
            }
            res.add(sb.toString());
        }
        System.out.println(res);
        List<String> res1 = new LinkedList<>();
        for(int i = 0; i < chess.length; i++){
            res1.add(new String(chess[i]));
        }
        for(char[] i : chess){
            res1.add(new String(i));
        }
        System.out.println(res1);

    }
}
