package PDD;

import java.util.Scanner;

public class Demo02 {
    static int method(int num){
        if(num <= 20 || num %10 == 0) return num;
        if(num < 1 || num > 100) return -1;
        for(int i = 1; ; i++){
            int tmp = num * i;
            if(check(tmp)) return tmp;
        }
//        return -1;
    }
    static boolean check(int num){
        int temp1,temp2 = 0;
        int count = 0;
        while(num != 0){
            int res = num % 10;
            if(res != 0 && res != 1){
                temp1 = res;
                count++;
                if(count > 1 && temp2 != temp1) return false;
                temp2 = temp1;
            }
            num /= 10;
        }
        return true;
    }
    public static void main(String[] args) {
//        Scanner sc =new Scanner(System.in);
//        int num = sc.nextInt();
//        int res = method(num);
        for(int i = 1; i <= 100; i++){
            int tmp=method(i);
            System.out.println(i + "-" +tmp);
        }

    }
}
