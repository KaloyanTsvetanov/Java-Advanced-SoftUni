import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Integer> num = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Predicate<Integer> isDivisible = number -> {
            for (Integer nums : num) {
                if (number % nums != 0){
                    return false;
                }
            }
            return true;
        };

        for (int i = 1; i <=n ; i++) {
            if(isDivisible.test(i)){
                System.out.print(i+" ");
            }
        }

    }
}