package Runnable;

import demo.Array;

import java.util.function.Consumer;

public class DemoConsumer {
    public static void method(String name, Consumer<String> con){
        con.accept(name);
    }

    public static void main(String[] args) {
        method("ljj",(String name)->{
//            System.out.println(name);
            String reName = new StringBuilder(name).reverse().toString();
            System.out.println(reName);
        });
    }
}
