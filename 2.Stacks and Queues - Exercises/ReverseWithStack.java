import java.util.*;
import java.util.stream.Collectors;

public class ReverseWithStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        List<Integer> list = Arrays
                .stream(input.split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        for(int n : list){
            stack.push(n);
        }
        while (!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }
    }
}
