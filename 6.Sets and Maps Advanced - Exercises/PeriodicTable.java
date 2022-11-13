import java.util.*;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int n = Integer.parseInt(input);

        Set<String> set = new TreeSet<>();

        while (n-->0){
            input= scanner.nextLine();
            Arrays
                    .stream(input.split("\\s+"))
                    .map(String::valueOf)
                    .forEach(set::add);
        }
        for(var e:set){
            System.out.print(e+" ");
        }
    }
}
