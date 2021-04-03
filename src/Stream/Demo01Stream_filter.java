package Stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Demo01Stream_filter {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("张三丰");
        list.add("赵敏");
        list.add("周芷若");
        list.add("哈斯卡");
        Stream<String> stream = list.stream();
        Stream<String> stream1 = stream.filter(name -> name.startsWith("张"));
        stream1.forEach(name-> System.out.println(name));
    }
    }
