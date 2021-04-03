package Runnable;

import java.util.ArrayList;
import java.util.function.Predicate;

public class Demo05Test {
    public static ArrayList<String> check(String[] arr, Predicate<String> pre1, Predicate<String> pre2){
        ArrayList<String> list = new ArrayList<>();
        for (String s : arr) {
            boolean b = pre1.and(pre2).test(s);
            if(b){
                list.add(s);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        String[] arr = {"abcd,1","cdfd,2","ASSD,1","FFFF,2"};
        ArrayList<String> list = check(arr, (String str) -> {
            return str.split(",")[1].equals("1");
        }, (String str) -> {
            return str.split(",")[0].contains("S");
        });
        for (String s : list) {
            System.out.println(s);
        }
    }

}
