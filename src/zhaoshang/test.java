package zhaoshang;
import java.util.Scanner;
public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long startTime=System.currentTimeMillis();;
        String s = sc.next();
        char[] ch = s.toCharArray();
        int len = ch.length;
        System.out.println(len);
        int ans = 0;
        for(int i = 0; i < len; i++){
            for (int j = 0; j <= i; j++){
                if(check(ch, j, i)){
                    ans = Math.max(ans, i - j + 1);
                }
            }
        }
        System.out.println(ans);
        long endTime=System.currentTimeMillis();
        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
    }
    static boolean check(char[] ch, int a, int b){
        int[] count = new int[5];
        while(a <= b){
            if(ch[a] == '1') count[0]++;
            if(ch[a] == '3') count[1]++;
            if(ch[a] == '4') count[2]++;
            if(ch[a] == '5') count[3]++;
            if(ch[a] == '6') count[4]++;
            a++;
        }
        for(int k = 0; k < 5; k++){
            if(count[k]%2 == 1) return false;
        }
        return true;
    }

}
