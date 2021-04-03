package leetcode;

import java.util.Arrays;

public class demo1109 {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int len = bookings.length;
        int[] answer = new int[n];
        int[] diff = new int[n];
        for(int i = 0; i < len; i++){
            diff[bookings[i][0]-1] += bookings[i][2];
            if(bookings[i][1] < n-1) diff[bookings[i][1]] -= bookings[i][2];
        }
        answer[0] = diff[0];
        for(int i = 1; i < n; i++){
                answer[i] = diff[i] + answer[i-1];
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] bookings = new int[][]{{1,2,10}, {2, 3, 20}, {2, 5, 25}};
        int n = 5;
        demo1109 demo = new demo1109();
        int[] ints = demo.corpFlightBookings(bookings, n);
        System.out.println(Arrays.toString(ints));
    }
}
