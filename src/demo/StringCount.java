package demo;

import java.util.Scanner;

public class StringCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入字符串：");
        String input = sc.next();

        int countUpper = 0;
        int countLower = 0;
        int countNumber = 0;
        int countOther = 0;

        char[] charArray = input.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char ch = charArray[i];
            if ('A' <= ch && ch <= 'Z'){
                countUpper ++;
            }
            if('a' <= ch && ch <= 'z'){
                countLower ++;
            }
            if ('0' <= ch && ch <= '9'){
                countNumber ++;
            } else {
                countOther ++;
            }

        }
        System.out.println("Upper:" + countUpper);
        System.out.println("Lower:" + countLower);
        System.out.println("Number:" + countNumber);
        System.out.println("Other:" + countOther);
    }
}
