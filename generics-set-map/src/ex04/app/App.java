package ex04.app;

import java.util.*;

public class App {
    public static void main(String[] args) {
        // Exemplo 1:
        /*
         Implementações do Set:
         Set<String> set = new HashSet<>();
         Set<String> set = new TreeSet<>();

         Set<String> set = new LinkedHashSet<>();

         set.add("TV");
         set.add("Tablet");
         set.add("Notebook");

         // Operações do set:
         // set.remove("TV");
         set.removeIf(x -> x.charAt(0) == 'T');

         for (String s : set) {
             System.out.println(s);
         }
        */

        // Exemplo 2:
        // Operações de conjutos:
        Set<Integer> a = new TreeSet<>(Arrays.asList(0, 2, 4, 5, 6, 8, 10));
        Set<Integer> b = new TreeSet<>(Arrays.asList(5, 6, 7, 8, 9, 10));

        // Unio:
        Set<Integer> c = new TreeSet<>(a);
        c.addAll(b);
        System.out.println(c);

        // Intersection:
        Set<Integer> d = new TreeSet<>(a);
        d.retainAll(b);
        System.out.println(d);

        // Difference:
        Set<Integer> e = new TreeSet<>(a);
        e.removeAll(b);
        System.out.println(e);
    }
}
