package pour.test;

import java.util.List;
import java.util.Optional;

public class Optionals {

    static class Dummy{
        private String value;

        public Dummy(String value) {
            this.value = value;
        }

        public String value() {
            return value;
        }

        public Dummy setValue(String value) {
            this.value = value;
            return this;
        }

        @Override
        public String toString() {
            return "Dummy{value='%s'}".formatted(value);
        }
    }

    public static void main(String[] args) {

        Dummy dummy = null;
        System.out.println( Optional.ofNullable(dummy).map(Dummy::value).orElse("dummy est null") );

        dummy = new Dummy(null);
        System.out.println( Optional.ofNullable(dummy).map(Dummy::value).orElse("value est null") );
        System.out.println( Optional.of(dummy).map(Dummy::value).orElse("value est null") );

        dummy = new Dummy("value");
        System.out.println( Optional.ofNullable(dummy).map(Dummy::value).orElse("value n'est pas null") );


        List<Dummy> dummies = List.of(new Dummy("un"), new Dummy("deux"), new Dummy("trois"), new Dummy("quatre"));

        Optional<Dummy> trois = dummies.stream().filter(d -> d.value.equals("trois")).findFirst();
        if(trois.isPresent()){
            trois.get().setValue("three");
        }

        dummies.forEach(System.out::println);


    }
}
