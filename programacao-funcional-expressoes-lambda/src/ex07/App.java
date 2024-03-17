package ex07;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3, 4, 5, 10, 7);

        Stream<Integer> st1 = list.stream().map(e -> e * 10);
        System.out.println(Arrays.toString(st1.toArray()));

        int sum = list.stream().reduce(0, (x, y) -> x + y);
        System.out.println(sum);

        List<Integer> newList = list.stream()
                .filter(e -> e % 2 == 0)
                .map(e -> e * 10)
                .toList();

        System.out.println(Arrays.toString(newList.toArray()));
    }
}
