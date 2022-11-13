import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> collect = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Function<List<Integer>, Integer> minElIndex = e -> {
            int maxValue = Integer.MAX_VALUE;
            int index = 0;
            for (int i = 0; i < e.size(); i++) {
                if (e.get(i) <= maxValue) {
                    maxValue = e.get(i);
                    index = i;
                }
            }
            return index;
        };
        System.out.println(minElIndex.apply(collect));
    }
}