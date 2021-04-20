package acwing.acwing141;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static void getNextdemo1(String s, int t){
        int n = s.length();
        int[] next = new int[n+1];
        char[] charArray = new char[n+1];
        for(int i = 1; i <= n; i++) charArray[i] = s.charAt(i-1);
        for(int i = 2, j = 0; i <= n; i++){
            while(j != 0 && charArray[i] != charArray[j+1]) j = next[j];
            if(charArray[i] == charArray[j+1]) j++;
            next[i] = j;
        }
        System.out.printf("Test case #%d\n", t);
        for (int i = 2; i <= n; ++i) {
            int j = i - next[i];
            if (i > j && i % j == 0) System.out.println(i + " " + i / j);
        }
        System.out.println();
    }

    static void getNextdemo2(String s, int t){
        int n = s.length();
        int[] next = new int[n];
        char[] charArray = new char[n];
        for(int i = 0; i < n; i++) charArray[i] = s.charAt(i);
        int j = -1;
        next[0] = j;
        for(int i = 1; i < n; i++){
            while(j >= 0 && charArray[i] != charArray[j+1]) j = next[j];
            if(charArray[i] == charArray[j+1]) j++;
            next[i] = j;
        }
        System.out.printf("Test case #%d\n", t);
        for(int i = 1; i < n; i++){
            int k = i - next[i];
            if(i+1 > k && (i+1)%k == 0) System.out.println(i + 1 + " " + (i + 1)/ k);
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        int t = 1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (t > 0){
            int n = Integer.parseInt(br.readLine());
            if(n == 0) break;
            String s = br.readLine();
            getNextdemo1(s, t++);

        }
    }
}