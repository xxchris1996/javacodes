package Runnable;

import java.util.function.Function;

public class DemoFuntion {
    public static void method(String s, Function<String,Integer> fun1, Function<Integer, String> fun2){
        String apply = fun1.andThen(fun2).apply(s);
        System.out.println(apply);
    }

    public static void main(String[] args) {
        String s = "124";
//        method(s,(String str)->{
//            return Integer.parseInt(str);
//        });
//        method(s,s1 -> Integer.parseInt(s1));
//        method(s, new Function<String, Integer>() {
//            @Override
//            public Integer apply(String s) {
//                return Integer.parseInt(s);
//            }
//        });
        method(s,(String str)->{
            return Integer.parseInt(str)+10;
        },(Integer integer)->{
            return integer.toString();
        });

        method(s,str -> Integer.parseInt(str) + 99, integer -> integer.toString());
    }
}
