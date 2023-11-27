package pour.gherkins;

import java.util.HashMap;
import java.util.Map;

public class Panier {

    private Map<String, Integer> chose = new HashMap<>();

    public void add(int num, String fruit) {
        Integer current = chose.getOrDefault(fruit, 0);
        chose.put(fruit, current + num);
    }

    public int nombre() {

        return chose.values().stream().mapToInt(Integer::intValue).sum();
    }
}
