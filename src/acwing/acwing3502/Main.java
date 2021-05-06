package acwing.acwing3502;

// import java.util.*;
// public class Main{
//     static Set<Integer> set = new HashSet<>();
//     static List<Integer> list = new ArrayList<>();
//     static int n;
//     static int m;
//     static int k;
//     public static void main(String[] args){
//         Scanner sc = new Scanner(System.in);
//         n = sc.nextInt();
//         m = sc.nextInt();
//         k = sc.nextInt();
//         int[][] nums = new int[n][m];
//         for(int i = 0; i < n; i++){
//             for(int j = 0; j < m; j++){
//                 nums[i][j] = sc.nextInt();
//             }
//         }
//         for(int i = 0; i < n; i++){
//             for(int j = 0; j < m; j++){
//                 dfs(nums, i, j, 0, 0);
//             }
//         }
//         System.out.println(set.size());
//     }
//     static void dfs(int[][] nums, int i, int j, int cnt, int num){
//         if (i < 0 || i >= n || j < 0 || j >= m) return;
//         num = num*10 + nums[i][j];
//         System.out.println(num);
//         if(cnt == k) {
//             set.add(num);
//             return;
//         }
//         dfs(nums, i - 1, j, cnt+1, num);
//         dfs(nums, i + 1, j, cnt+1, num);
//         dfs(nums, i, j - 1, cnt+1, num);
//         dfs(nums, i, j + 1, cnt+1, num);
//     }
// }
import java.util.*;
public class Main{
    static Set<List> set = new HashSet<>();
    static List<Integer> list = new ArrayList<>();
    static int n;
    static int m;
    static int k;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        int[][] nums = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                nums[i][j] = sc.nextInt();
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                dfs(nums, i, j, 0, 0);
            }
        }
        System.out.println(set.size());
    }
    static void dfs(int[][] nums, int i, int j, int cnt, int num){
        if (i < 0 || i >= n || j < 0 || j >= m) return;
//        list.add(nums[i][j]);
        // System.out.println("cnt "+ cnt);
        // System.out.println(list);
        if(list.size() == k+1) {
            set.add(new ArrayList(list));
            // System.out.println("cnt "+ cnt);
            // System.out.println(list);
            return;
        }
        list.add(nums[i][j]);
        dfs(nums, i - 1, j, cnt+1, num);
        list.remove(list.size()-1);
        list.add(nums[i][j]);
        dfs(nums, i + 1, j, cnt+1, num);
        list.remove(list.size()-1);
        list.add(nums[i][j]);
        dfs(nums, i, j - 1, cnt+1, num);
        list.remove(list.size()-1);
        list.add(nums[i][j]);
        dfs(nums, i, j + 1, cnt+1, num);
        list.remove(list.size()-1);

    }
}