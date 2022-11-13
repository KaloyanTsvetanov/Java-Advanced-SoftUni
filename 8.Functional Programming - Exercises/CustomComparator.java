import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class CustomComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();
        Consumer<Integer> output = e-> System.out.print(e+" ");

        List<Integer> collect = Arrays.
                stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());
        even = collect.stream().filter(e->e%2==0).collect(Collectors.toList());
        odd = collect.stream().filter(e->e%2!=0).collect(Collectors.toList());
        even.forEach(output);
        odd.forEach(output);

    }
}