package Stream;

import java.util.ArrayList;
import java.util.List;
import java.util.SplittableRandom;
import java.util.stream.Stream;

public class Demo02Stream_forEach {
    public static void main(String[] args){
        List<String> list = new ArrayList<>();
        list.add("张三");
        list.add("李四");
        list.add("王五");
        list.add("赵六");
        list.add("田七");
        Stream<String> stream = list.stream();
//        stream.forEach((String name)->{
//            System.out.println(name);
//        });
        stream.forEach(name-> System.out.println(name));
//        stream.forEach(name-> System.out.println(name));
    }
}
