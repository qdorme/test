package pour.test;

import java.util.Random;
import java.util.function.Supplier;

public class Lazy <T>{
    private T instance;
    private Supplier<T> supplier;

    public Lazy(Supplier<T> supplier){
        this.supplier = supplier;
    }

    public T get(){
        if(instance == null){
            instance = supplier.get();
        }
        return instance;
    }

    public static void main(String[] args) {

        int num = new Random().nextInt();

        Lazy<Integer> lazy = new Lazy<>(()-> {
            System.out.println("on execute le process...");
            return 100;
        } ); // un processus extremement long

        if(num > 1000 && lazy.get() >50){
            System.out.println("on rentre dedans avec la lazy qui vaut " + lazy.get());
        }else {
            System.out.println("le long process n'a pas été executé");
        }



    }
}
