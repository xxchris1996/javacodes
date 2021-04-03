package Runnable.DemoFunctionTest;

import java.util.function.Function;

public class javva {
    public static int method(String s, Function<String, String> fun1, Function<String, Integer> fun2, Function<Integer, Integer> fun3){
        return fun1.andThen(fun2).andThen(fun3).apply(s);
    }

    public static void main(String[] args) {
        String str = "ava,123";
        int method = method(str, s -> s.split(",")[1], s -> Integer.parseInt(s), s -> s + 100);
        System.out.println(method);
    }
}
