package leetcode;

public class demo1723 {
    static int ans = Integer.MAX_VALUE;
    public static int minimumTimeRequired(int[] jobs, int k) {
        // Arrays.sort(jobs);
        int[] sum = new int[k];
        dfs(0, sum, 0, jobs, k, 0);
        return ans;
    }
    static void dfs(int u, int[] sum, int max, int[] jobs, int k, int used){
        if(max >= ans) return;
        if(u == jobs.length){
            ans = max;
            return;
        }
        if(used < k){
            sum[used] = jobs[u];
            dfs(u+1, sum, Math.max(max, sum[used]), jobs, k, used + 1);
            sum[used] = 0;
        }
        for(int i = 0; i < used; i++){
            sum[i] += jobs[u];
            dfs(u+1, sum, Math.max(max, sum[i]), jobs, k, used);
            sum[i] -= jobs[u];
        }
    }

    public static void main(String[] args) {
        int[] jobs = new int[]{1,1,1,7,8,9};
        int i = minimumTimeRequired(jobs, 4);
        System.out.println(i);
    }
}
