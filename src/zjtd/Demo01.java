package zjtd;

import java.util.Scanner;

public class Demo01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            String s = sc.next();
            char c = s.charAt(0);
            int type = check(c);
            int num = 0;
            if (type == 0) {
                num = c - '0';
            } else if (type == 1) {
                num = c - 'A' + 1;
            } else {
                num = 1;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                char cha = s.charAt(i);
                int ty = check(cha);
                if (ty == 0) {
                    int tmp = num % 10;
                    if (cha - '0' + tmp > 9) {
                        cha = (char) (cha - (9 - tmp + 1));
                    } else {
                        cha = (char) (cha + tmp);
                    }
                } else if (ty == 1) {
                    int tmp = num % 26;
                    if (cha + tmp > 'Z') {
                        cha = (char) (cha - (25 - tmp + 1));
                    } else {
                        cha = (char) (cha + tmp);
                    }
                }

                sb.append(cha);
            }

            System.out.println(sb.toString());
        }
    }
    public static int check (char c)
    {
        if (Character.isDigit(c))
        {
            return 0;
        }
        else if ( c >= 'A' && c <= 'Z')
        {
            return 1;
        }
        else
        {
            return 2;
        }
    }
}