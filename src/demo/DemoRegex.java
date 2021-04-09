package demo;

import java.util.Arrays;

public class DemoRegex {
    public static void main(String[] args) {
        String str =  "[-1,2,3,4,5]";
        System.out.println(str);
//        String[] split = str.split("\\d");
        String[] split = str.split("\\D");
        for (String s : split) {
            System.out.println(s);
        }
        System.out.println(Arrays.toString(split));
        System.out.println(split[split.length-1]);
        System.out.println(split.length);
    }
}
