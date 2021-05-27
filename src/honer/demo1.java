package honer;

public class demo1 {
    public static void main(String[] args) {
        int n = 100;
        int k = 15;
        long ans = 0;
        for (int i = 1; i <= k; i++) {
            ans += pow(n, i) % mod;
        }
        System.out.println(ans % mod);
    }

    private static int mod = 1000000007;

    public static long pow(long a, long b) {
        long ans = 1;
        while(b != 0){
            if(b%2 == 1) ans = (a * ans)%mod;
            b /= 2;
            a = (a * a) % mod;
        }
        return ans % mod;
    }
}
