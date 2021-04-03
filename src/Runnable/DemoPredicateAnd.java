package Runnable;

import java.util.function.Predicate;

public class DemoPredicateAnd {
    public static boolean check(String s, Predicate<String> pre1, Predicate<String> pre2){
        return pre1.and(pre2).test(s);
    }

    public static void main(String[] args) {
        String s = "abcde";
        boolean check = check(s, (String str) -> {
            return s.length() > 5;
        }, (String str) -> {
            return str.contains("a");
        });
        System.out.println(check);
    }
}
