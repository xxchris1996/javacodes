package tonghuashun;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;

public class demo7011 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ArrayList<Integer> list = new ArrayList<>();
        Class c1 = list.getClass();
        Method add = c1.getMethod("add", Object.class);
        Object invoke = add.invoke(list, "hello");
        System.out.println(list.toString());
    }
}
