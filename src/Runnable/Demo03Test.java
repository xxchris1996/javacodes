package Runnable;

import java.util.function.Consumer;

public class Demo03Test {
    public static void printInfo(String[] arr, Consumer<String>  con1, Consumer<String> con2){
        for (String s : arr) {
            con1.andThen(con2).accept(s);
        }
    }

    public static void main(String[] args) {
        String[] arr = {"哈斯卡,力量","敌法师,敏捷"};
        printInfo(arr,(s)->{
            String name = s.split(",")[0];
            System.out.print(name);
        },(s)->{
            String repository = s.split(",")[1];
            System.out.println(repository);
        });
    }
}
