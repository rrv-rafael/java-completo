package ex06;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3, 4, 5, 10, 7);

        Stream<Integer> st1 = list.stream().map(e -> e * 10);
        System.out.println(Arrays.toString(st1.toArray()));

        Stream<String> st2 = Stream.of("Maria", "Alex", "Bob");
        System.out.println(Arrays.toString(st2.toArray()));

        Stream<Integer> st3 = Stream.iterate(0, e -> e + 2);
        System.out.println(Arrays.toString(st3.limit(10).toArray()));

        Stream<Long> st4 = Stream.iterate(new Long[] {0L, 1L}, e -> new Long[] {e[1], e[0] + e[1]}).map(e -> e[0]);
        System.out.println(Arrays.toString(st4.limit(20).toArray()));
    }
}