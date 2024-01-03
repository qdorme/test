package stream;


import java.util.List;

import static java.lang.System.out;
import static java.util.List.of;

public class FlatMapExample {

    record Dummy(int value){}
    record Dummies(List<Dummy> dummies){}

    public static void main(String[] args) {

        List<Dummies> dummies = of(
                new Dummies(of(new Dummy(1),new Dummy(2))),
                new Dummies(of(new Dummy(3))),
                new Dummies(of(new Dummy(4),new Dummy(5),new Dummy(6))),
                new Dummies(of(new Dummy(7),new Dummy(8)))
        );

        List<List<Dummy>> list = dummies.stream().map(Dummies::dummies).toList();
        out.println(list); // [[Dummy[value=1], Dummy[value=2]], [Dummy[value=3]], [Dummy[value=4], Dummy[value=5], Dummy[value=6]], [Dummy[value=7], Dummy[value=8]]]
        List<Dummy> list1 = dummies.stream().flatMap(d -> d.dummies().stream()).toList();
        out.println(list1); // [Dummy[value=1], Dummy[value=2], Dummy[value=3], Dummy[value=4], Dummy[value=5], Dummy[value=6], Dummy[value=7], Dummy[value=8]]
    }
}
