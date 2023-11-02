package pour.test;

import java.util.Optional;

public class Optionals {

    static Optional<String> getText(){
        return Optional.ofNullable(null);
    }


    public static void main(String[] args) {

        Optional<String> empty = Optionals.getText();

        System.out.println(empty.get());

    }
}
