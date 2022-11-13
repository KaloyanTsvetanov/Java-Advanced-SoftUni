import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> num = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("end")) {

            num = getAction(num, input);

            input = scanner.nextLine();
        }
    }

    private static List<Integer> getAction(List<Integer> num, String input) {
        List<Integer> current = new ArrayList<>();
        switch (input) {
            case "add":
                num.forEach(e -> current.add(e + 1));
                return current;
            case "subtract":
                num.forEach(e -> current.add(e - 1));
                return current;
            case "multiply":
                num.forEach(e -> current.add((e * 2)));
                return current;
            case "print":
                num.forEach(e-> System.out.print(e+" "));
                System.out.println();
                return num;
        }
        return num;
    }
}