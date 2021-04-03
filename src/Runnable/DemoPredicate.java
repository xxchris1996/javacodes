package Runnable;

import java.util.function.Predicate;

public class DemoPredicate {
    public static boolean check(String s, Predicate<String> pre){
        return pre.test(s);
    }

    public static void main(String[] args) {
        String s = "abcde";
        boolean check = check(s, str->str.length()>5);
        System.out.println(check);
    }
}
