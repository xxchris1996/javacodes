package Stream;

import java.util.ArrayList;
import java.util.stream.Stream;

public class Demo05Stream_count {
    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        Stream<Integer> stream1 = list.stream();
        Stream<Integer> stream2 = list.stream();
        Stream<Integer> concat = Stream.concat(stream1, stream2);
        concat.forEach(i-> System.out.println(i));
//        long count = stream.count();
//        Stream<Integer> limit = stream.limit(4);
//        long count = limit.count();
//        Stream<Integer> skip = stream.skip(3);
//        skip.forEach(i-> System.out.println(i));
//        limit.forEach(i-> System.out.println(i));
//        System.out.println(count);
    }
}
