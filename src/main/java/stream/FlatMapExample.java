package stream;


import java.util.Collection;
import java.util.List;

import static java.lang.System.out;
import static java.util.List.of;

public class FlatMapExample {

    public static void main(String[] args) {

        List<List<String>> lls = of(
                of("a", "b"),
                of("c", "d", "e"),
                of("f", "g")
        );

        out.println(lls); // [[a, b], [c, d, e], [f, g]]

        List<String> ls = lls.stream()
                .flatMap(Collection::stream)
                .toList();

        out.println(ls); // [a, b, c, d, e, f, g]

    }

}
