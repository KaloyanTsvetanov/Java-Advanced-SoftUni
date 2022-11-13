import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> bombEffect = new ArrayDeque<>();
        ArrayDeque<Integer> bombCasing = new ArrayDeque<>();

        Map<String, Integer> bombMap = new LinkedHashMap<>();
        bombMap.put("Cherry Bombs", 0);
        bombMap.put("Datura Bombs", 0);
        bombMap.put("Smoke Decoy Bombs", 0);

        String[] tokens = scanner.nextLine().split(", ");
        for (String token : tokens) {
            bombEffect.offer(Integer.parseInt(token));
        }

        tokens = scanner.nextLine().split(", ");
        for (String token : tokens) {
            bombCasing.push(Integer.parseInt(token));
        }
        int cc = 0;
        while ((!bombEffect.isEmpty() && !bombCasing.isEmpty()) && cc != 3) {
            cc = 0;

            int firstEffect = bombEffect.peek();
            int lastCasing = bombCasing.peek();
            int sum = firstEffect + lastCasing;
            switch (sum) {
                case 40:
                    int a = bombMap.get("Datura Bombs");
                    a += 1;
                    bombMap.put("Datura Bombs", a);
                    bombEffect.poll();
                    bombCasing.pop();
                    break;
                case 60:
                    int a1 = bombMap.get("Cherry Bombs");
                    a1 += 1;
                    bombMap.put("Cherry Bombs", a1);
                    bombEffect.poll();
                    bombCasing.pop();
                    break;
                case 120:
                    int a2 = bombMap.get("Smoke Decoy Bombs");
                    a2 += 1;
                    bombMap.put("Smoke Decoy Bombs", a2);
                    bombEffect.poll();
                    bombCasing.pop();
                    break;
                default:
                    int decrease = bombCasing.pop();
                    decrease -= 5;
                    bombCasing.push(decrease);
                    break;
            }
            for (Map.Entry<String, Integer> entry : bombMap.entrySet()) {
                if (entry.getValue() >= 3) {
                    cc++;
                }
            }

        }
        if (cc == 3) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }
        if (!bombEffect.isEmpty()) {
            List<String> result = new ArrayList<>();
            System.out.print("Bomb Effects: ");
            for (Integer integer : bombEffect) {
                result.add(integer.toString());
            }
            System.out.println(String.join(", ", result));
        } else {
            System.out.println("Bomb Effects: empty");
        }

        if (!bombCasing.isEmpty()) {
            List<String> result = new ArrayList<>();
            System.out.print("Bomb Casings: ");
            for (Integer integer : bombCasing) {
                result.add(integer.toString());
            }
            System.out.print(String.join(", ", result));
        } else {
            System.out.print("Bomb Casings: empty");
        }
        System.out.println();
        for (Map.Entry<String, Integer> entry : bombMap.entrySet()) {
            System.out.printf("%s: %d%n", entry.getKey(),entry.getValue());

        }

    }
}
