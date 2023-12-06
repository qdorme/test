package pour.test.fonctionnel;

import java.util.function.Predicate;

public class Compound {

    private static final Predicate<String> EST_TOTO = "TOTO"::equals;
    private static final Predicate<String> EST_TITI = "TITI"::equals;

    public static void main(String[] args) {
        System.out.println(EST_TOTO.or(EST_TITI).test("TOTO") ); // true
        System.out.println(EST_TOTO.or(EST_TITI).test("TITI") ); // true
        System.out.println(EST_TOTO.or(EST_TITI).test("TATA") ); // false

        System.out.println(!EST_TOTO.or(EST_TITI).test("TOTO")); // false
        System.out.println(!EST_TOTO.or(EST_TITI).test("TITI")); // false
        System.out.println(!EST_TOTO.or(EST_TITI).test("TATA")); // true
        


    }

}
