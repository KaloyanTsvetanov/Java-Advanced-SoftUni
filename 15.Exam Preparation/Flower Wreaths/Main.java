import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> lilies = new ArrayDeque<>();
        ArrayDeque<Integer> roses = new ArrayDeque<>();

        String[] tokens = scanner.nextLine().split(", ");
        for (String token : tokens) {
            lilies.push(Integer.parseInt(token));
        }
        tokens = scanner.nextLine().split(", ");
        for (String token : tokens) {
            roses.offer(Integer.parseInt(token));
        }

        int wraith = 0;
        int storedFlowers = 0;

        while (!lilies.isEmpty() && !roses.isEmpty()) {
            int firstLilie = lilies.peek();
            int lastRose = roses.peek();
            int sum = firstLilie + lastRose;

            switch (sum) {
                case 15:
                    wraith++;
                    lilies.poll();
                    roses.pop();
                    break;
                default:
                    if (sum > 15) {
                        int a = lilies.poll();
                        a -= 2;
                        lilies.offer(a);
                    } else {
                        storedFlowers += sum;
                        lilies.poll();
                        roses.pop();
                    }
                    break;
            }
        }
        while (storedFlowers >= 15) {
            wraith++;
            storedFlowers -= 15;
        }
        if (wraith >= 5) {
            System.out.printf("You made it, you are going to the competition with %d wreaths!", wraith);
        } else System.out.printf("You didn't make it, you need %d wreaths more!", (5 - wraith));

    }

}

