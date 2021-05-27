package vivo;
import java.util.Arrays;
import java.util.Scanner;

public class demo3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] a = sc.nextLine().split(",");
        String[] b = sc.nextLine().split(";");
        int n = a.length;
        int[] v = new int[n+1];
        for(int i=0; i<n; i++)
        {
            v[i+1] = Integer.parseInt(a[i]);
        }
        int[][] w = new int[n+1][n+1];
        for(int i=0; i<=n; i++) Arrays.fill(w[i],Integer.MIN_VALUE);
        int[] last = new int[n+1];
        Arrays.fill(last,-1);
        for(int i=0; i<n; i++)
        {
            String[] tmp = b[i].split(",");
//            System.out.println(Arrays.toString(tmp));
            for(String s : tmp)
            {
                int t = Integer.valueOf(s);
                if(t==0)
                {
                    last[i+1] = 0;
                    continue;
                }
                w[i+1][t] = v[t];
            }
        }
        System.out.println(Arrays.toString(last));
        for (int i=1; i<=n; i++)
        {
            System.out.println(Arrays.toString(w[i]));
        }

        for(int m=1; m<=n; m++)
        {
            for(int i=1; i<=n; i++)
            {
                for(int j=1; j<=n; j++)
                {
                    if(w[i][m]!= Integer.MIN_VALUE &&w[m][j]!= Integer.MIN_VALUE&&w[i][m] + w[m][j] > w[i][j])
                    {
                        w[i][j] = w[i][m] + w[m][j];
                    }
                }
            }
        }
//        System.out.println(w[1][6]);
        int max = 0;
        for(int i=1; i<=n; i++)
        {
            if(last[i] == 0)
            {
                max = Math.max(max,w[1][i]);
            }
        }
        System.out.println(max+v[1]);
    }
}
