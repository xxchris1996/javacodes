package acwing.acwing3636;
import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-- != 0){
            int n = sc.nextInt();
            int[] num = new int[n];
            int x = sc.nextInt();
            Long sum = 0L;
            Long psum = 0L;
            int cnt = Integer.MAX_VALUE;
            for(int i = 0; i < n; i++){
                num[i] = sc.nextInt();
                sum += num[i];
                int c = 0;
                for(int j = num[i]; j % x == 0; j /= x) c++;
                if(c < cnt) {
                    cnt = c;
                    psum = sum - num[i];
                }
            }
            System.out.println(sum*(cnt+1)+psum);
        }
    }
}
