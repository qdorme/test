package pour.test;

import java.io.PrintStream;

public class ReplaceSystemOut {

    private final PrintStream out;

    public ReplaceSystemOut(PrintStream out) {
        this.out = out;
    }

    public void doSomething(){
        out.println("Hello world !!!");
    }

    public static void main(String[] args) {
        ReplaceSystemOut system = new ReplaceSystemOut(System.out);
        system.doSomething();
    }

}
