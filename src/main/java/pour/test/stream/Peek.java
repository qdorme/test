package pour.test.stream;

import java.util.List;

public class Peek {

    private int value;
    private String text;

    public Peek(int value) {
        this.value = value;
    }

    public static void main(String[] args) {
        List<Integer> integers = List.of(1, 2, 3);

        List<Peek> hoHo = integers.stream()
                .map( Peek::new)
                .peek(p -> p.setText("ho ho"))
                .toList();

        hoHo.forEach( p -> System.out.println(p.getText()));

    }

    public int getValue() {
        return value;
    }

    public Peek setValue(int value) {
        this.value = value;
        return this;
    }

    public String getText() {
        return text;
    }

    public Peek setText(String text) {
        this.text = text;
        return this;
    }
}
