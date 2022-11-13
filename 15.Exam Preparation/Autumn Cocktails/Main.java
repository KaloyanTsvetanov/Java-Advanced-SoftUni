import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> ingredients = new ArrayDeque<>();
        ArrayDeque<Integer> freshnessLevel = new ArrayDeque<>();
        Map<String, Integer> presents = new TreeMap<>();

        String input = scanner.nextLine();

        String[] numbers = input.split("\\s+");

        for (String number : numbers) {
            ingredients.offer(Integer.parseInt(number));
        }
        input = scanner.nextLine();
        numbers = input.split("\\s+");
        for (String number : numbers) {
            freshnessLevel.push(Integer.parseInt(number));
        }
        boolean pear = false;
        boolean harvest = false;
        boolean apple = false;
        boolean fashion = false;

        while (!freshnessLevel.isEmpty() && !ingredients.isEmpty()) {
            int sum = 0;
            int a = ingredients.peek();
            int b = freshnessLevel.peek();
            if (a == 0) {
                ingredients.poll();
                continue;
            }
            sum = a * b;
            switch (sum) {
                case 150:
                    presents.putIfAbsent("Pear Sour", 0);
                    int current = presents.get("Pear Sour");
                    current += 1;
                    presents.put("Pear Sour", current);
                    ingredients.poll();
                    freshnessLevel.pop();
                    pear = true;
                    break;
                case 250:
                    presents.putIfAbsent("The Harvest", 0);
                    int current1 = presents.get("The Harvest");
                    current1 += 1;
                    presents.put("The Harvest", current1);
                    ingredients.poll();
                    freshnessLevel.pop();
                    harvest = true;
                    break;
                case 300:
                    presents.putIfAbsent("Apple Hinny", 0);
                    int current2 = presents.get("Apple Hinny");
                    current2 += 1;
                    presents.put("Apple Hinny", current2);
                    ingredients.poll();
                    freshnessLevel.pop();
                    apple = true;
                    break;
                case 400:
                    presents.putIfAbsent("High Fashion", 0);
                    int current3 = presents.get("High Fashion");
                    current3 += 1;
                    presents.put("High Fashion", current3);
                    ingredients.poll();
                    freshnessLevel.pop();
                    fashion = true;
                    break;
                default:
                    int y = ingredients.poll();
                    y += 5;
                    ingredients.offer(y);
                    freshnessLevel.pop();
                    break;
            }

        }
        if (pear && harvest && apple && fashion) {
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }
        if (!ingredients.isEmpty()) {
            int result = 0;
            while (!ingredients.isEmpty()) {
                result += ingredients.poll();
            }
            System.out.print("Ingredients left: " + result);
            System.out.println();
        }
        presents.entrySet().forEach((k) ->
                System.out.println(" # " + k.getKey() + " --> " + k.getValue())
        );
    }
}
