package stream;

import java.util.List;

import static java.lang.System.out;
import static java.util.List.of;

public class ReduceExample {

    public static void main(String[] args) {
        List<Integer> nums = of(1, 2, 3, 4, 5);

        Integer sum = nums.stream().reduce(0, Integer::sum);

        out.println(sum); // 15



    }
}
