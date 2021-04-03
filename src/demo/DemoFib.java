package demo;

public class DemoFib {
    public int fib(int n){
        if( n == 1 || n == 2) return 1;
        return fib(n - 1) + fib(n - 2);
    }

    public int fib1(int n ){
        if(n < 1) return 0;
        int[] memo = new int[n+1];
        return helper(memo, n);
    }

    public int helper(int[] memo, int n){
        if(n == 1 || n == 2) return 1;
        if(memo[n] != 0) return memo[n];
        memo[n] = helper(memo, n - 1) + helper(memo, n - 2);
        return memo[n];
    }

    public static void main(String[] args) {
        DemoFib demoFib = new DemoFib();
        int n = 20;
        double start = System.currentTimeMillis();
        long result1 = demoFib.fib(50);
        System.out.println(result1);
        double end = System.currentTimeMillis();
        System.out.println((long)(end - start));
        double start1 = System.currentTimeMillis();
        long result2 = demoFib.fib1(50);
        System.out.println(result2);
        double end1 = System.currentTimeMillis();
        System.out.println(end1 - start1);
    }
}
