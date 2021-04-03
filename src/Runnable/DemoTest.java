package Runnable;

import java.util.Arrays;
import java.util.function.Supplier;

public class DemoTest {
    public static int getMax(Supplier<Integer> sup){
        return sup.get();
    }

    public static void main(String[] args) {
        int[] arr = {100,24,1233,41,24};
        int maxValue = getMax(() -> {
            int max = arr[0];
            for (int i : arr) {
                if (i > max) {
                    max = i;
                }
            }
            return max;
        });
        System.out.println(maxValue);
    }
}
