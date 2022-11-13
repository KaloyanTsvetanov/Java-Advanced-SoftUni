import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> numberOfMaterials = new ArrayDeque<>();
        ArrayDeque<Integer> magicLevel = new ArrayDeque<>();
        Map<String, Integer> presents = new TreeMap<>();

        String input = scanner.nextLine();

        String[] numbers = input.split("\\s+");

        for (String number : numbers) {
            numberOfMaterials.push(Integer.parseInt(number));
        }
        input = scanner.nextLine();
        numbers = input.split("\\s+");
        for (String number : numbers) {
            magicLevel.offer(Integer.parseInt(number));
        }
        boolean doll = false;
        boolean train = false;
        boolean teddy = false;
        boolean bicycle = false;

        while (!magicLevel.isEmpty() && !numberOfMaterials.isEmpty()) {
            int sum = 0;
            int a = numberOfMaterials.peek();
            int b = magicLevel.peek();
            sum = a * b;
            if (a == 0 && b == 0) {
                numberOfMaterials.pop();
                magicLevel.poll();
                continue;
            } else if (a == 0) {
                numberOfMaterials.pop();
                continue;
            } else if (b == 0) {
                magicLevel.poll();
                continue;
            }
            sum = a * b;
            switch (sum) {
                case 150:
                    presents.putIfAbsent("Doll", 0);
                    int current = presents.get("Doll");
                    current += 1;
                    presents.put("Doll", current);
                    numberOfMaterials.pop();
                    magicLevel.poll();
                    doll = true;
                    break;
                case 250:
                    presents.putIfAbsent("Wooden train", 0);
                    int current1 = presents.get("Wooden train");
                    current1 += 1;
                    presents.put("Wooden train", current1);
                    numberOfMaterials.pop();
                    magicLevel.poll();
                    train = true;
                    break;
                case 300:
                    presents.putIfAbsent("Teddy bear", 0);
                    int current2 = presents.get("Teddy bear");
                    current2 += 1;
                    presents.put("Teddy bear", current2);
                    numberOfMaterials.pop();
                    magicLevel.poll();
                    teddy = true;
                    break;
                case 400:
                    presents.putIfAbsent("Bicycle", 0);
                    int current3 = presents.get("Bicycle");
                    current3 += 1;
                    presents.put("Bicycle", current3);
                    numberOfMaterials.pop();
                    magicLevel.poll();
                    bicycle = true;
                    break;
                default:
                    if (sum < 0) {
                        sum = a + b;
                        numberOfMaterials.pop();
                        magicLevel.poll();
                        numberOfMaterials.push(sum);
                    } else {
                        magicLevel.poll();
                        a += 15;
                        numberOfMaterials.pop();
                        numberOfMaterials.push(a);
                    }
                    break;
            }

        }
        if ((doll && train) || (teddy && bicycle)) {
            System.out.println("The presents are crafted! Merry Christmas!");
        } else {
            System.out.println("No presents this Christmas!");
        }
        if (!numberOfMaterials.isEmpty()) {
            List<String> result = new ArrayList<>();
            System.out.print("Materials left: ");
            while (!numberOfMaterials.isEmpty()) {
                result.add(numberOfMaterials.pop().toString());
            }
            System.out.print(String.join(", ", result));
            System.out.println();
        }
        if (!magicLevel.isEmpty()) {
            List<String> result = new ArrayList<>();
            System.out.print("Magic left: ");
            while (!magicLevel.isEmpty()) {
                result.add(magicLevel.poll().toString());
            }
            System.out.print(String.join(", ", result));
            System.out.println();
        }
        presents.entrySet().forEach((k) ->
                System.out.println(k.getKey() + ": " + k.getValue())
        );
    }
}
