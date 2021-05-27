package NC.NC19;

public class main {
    public static int maxsumofSubarray (int[] arr) {
        // write code here
        int n = arr.length;
        int[] dp = new int[n+1];
        int max = 0;
        for(int i = 1; i <= n; i++){
            dp[i] = dp[i-1] + arr[i-1];
            dp[i] = Math.max(0, dp[i]);
            System.out.println(dp[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, -2, 3, 5, -2, 6, -1};
        int i = maxsumofSubarray(arr);
        System.out.println(i);
    }
}
