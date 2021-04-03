package Stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Demo04Stream_map {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        Stream<String> stream = list.stream();
        Stream<Integer> integerStream = stream.map((s) -> {
            return Integer.parseInt(s);
        });
        integerStream.forEach(i-> System.out.println(i));
    }
}
