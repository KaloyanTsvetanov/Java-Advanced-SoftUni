import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Function<String,String> output = p->"Sir "+p;
        Consumer<String> output1 = System.out::println;

        Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(output)
                .forEach(output1);
    }
}