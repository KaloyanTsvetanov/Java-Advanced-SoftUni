import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Consumer<Integer> output = e -> System.out.print(e + " ");
        Deque<Integer> stack = new ArrayDeque<>();
        List<Integer> num = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt)
                .collect(Collectors.toList());
        int n = Integer.parseInt(scanner.nextLine());
        num.stream().filter(e -> e % n != 0).forEach(stack::push);
        stack.forEach(output);

    }
}