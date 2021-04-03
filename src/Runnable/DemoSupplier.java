package Runnable;

import java.util.function.Supplier;

public class DemoSupplier {
    public static String getString(Supplier<String> sup){
        return sup.get();
    }

    public static void main(String[] args) {
        String s = getString(() -> {
            return "avv";
        });
        String b = getString(() -> "asf");
        System.out.println(s);
        System.out.println(b);
    }
}
