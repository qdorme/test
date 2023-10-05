package pour.test.stream;

import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;

import static java.lang.Double.isNaN;

public class OptionalAndCo {

    private static final ToDoubleFunction<String> AU_CARRE = s -> {
        if(s.isBlank())
            return Double.NaN;
        return Double.valueOf(s) * Double.valueOf(s);
    };


    public static void main(String[] args) {
        List<String> doubles = List.of("3.14", "5.2","");


        OptionalDouble d = doubles.stream()
                .mapToDouble(AU_CARRE)
                .filter(Double::isNaN)
                .max();

        System.out.println(d);

        Float f = ((Double)d.orElse(Double.NaN)).floatValue();

        System.out.println(f);

    }
}
