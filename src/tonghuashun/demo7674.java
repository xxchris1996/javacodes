package tonghuashun;

import java.util.Arrays;
import java.util.Scanner;

public class demo7674 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }//2,0,1,0,3,0,4,0,0,5
        method(arr);
    }
    static void method(int[] arr){
        int slow = 0, fast = 0;
        while(fast < arr.length){
            if(arr[fast] != 0){
                arr[slow] = arr[fast];
                slow++;
            }
            fast++;
        }
        while(slow < arr.length){
            arr[slow] = 0;
            slow++;
        }
        System.out.println(Arrays.toString(arr));
    }
}
