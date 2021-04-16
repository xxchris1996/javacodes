package T;

public class mypow {
    private long mod = 1000000007;
    public long powmod (long a, long b){
        long res = 1;
        a %= mod;
        assert b >= 0;
        for(; b!= 0; b >>= 1){
            if((b&1) == 1) res = res * a % mod;
            a = a * a % mod;
        }
        return res;
    }

    public static void main(String[] args) {
        mypow pow = new mypow();
        long powmod1 = pow.powmod(2, 3);
        System.out.println(powmod1);
    }
}
