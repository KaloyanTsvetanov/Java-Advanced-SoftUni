import java.util.*;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<Character, Integer> map = new TreeMap<>();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            map.putIfAbsent(ch, 0);
            int oldValue = map.get(ch);
            int newValue = oldValue + 1;
            map.put(ch, newValue);
        }
        map.forEach((e, k) ->
                System.out.printf("%s: %d time/s%n", e, k)
        );
    }
}
