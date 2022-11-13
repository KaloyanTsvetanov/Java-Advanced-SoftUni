import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Predicate<String> predicate = e -> e.length() <= n;
        Consumer<String> output = System.out::println;
        Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(String::valueOf)
                .filter(predicate)
                .forEach(output);

    }
}