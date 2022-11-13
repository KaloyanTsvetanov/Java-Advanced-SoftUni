import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SumNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> num = Arrays
                .stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Function<List<Integer>,String> countFormat = l -> "Count = "+ l.size();
        Function<List<Integer>,Integer> sumAll = l -> l.stream().mapToInt(e->e).sum();
        Function<Integer,String> sumFormat = l -> "Sum = " + l;

        String outPut = countFormat.apply(num);
        Integer sum = sumAll.apply(num);
        String out = sumFormat.apply(sum);

        System.out.println(outPut);
        System.out.println(out);

    }
}
