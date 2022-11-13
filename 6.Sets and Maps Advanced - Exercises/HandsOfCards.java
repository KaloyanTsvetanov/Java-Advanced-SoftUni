import java.util.*;
import java.util.regex.Pattern;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Set<String>> map = new LinkedHashMap<>();

        String input = scanner.nextLine();
        Pattern pattern = Pattern.compile("[\\:\\s+\\,\\s+][\\s+]");
        while (!input.equals("JOKER")) {

            String name = input.split(pattern.pattern())[0];
            map.putIfAbsent(name, new LinkedHashSet<>());

            for (int i = 1; i < input.split(pattern.pattern()).length; i++) {
                map.get(name).add(input.split(pattern.pattern())[i]);
            }

            input = scanner.nextLine();
        }

        for (var entry : map.entrySet()) {
            String name = entry.getKey();
            int points = (calculatePoint(entry.getValue()));

            System.out.printf("%s: %d%n", name, points);
        }

    }

    private static int calculatePoint(Set<String> card) {
        int points = 0;
        for (var cards : card) {
            String cardNumber = cards.substring(0, cards.length() - 1);

            char power = cards.charAt(cards.length() - 1);

            int cardPoints = getPower(cardNumber) * getType(power);
            points += cardPoints;
        }
        return points;
    }

    private static int getPower(String cardNumber) {
        switch (cardNumber) {
            case "J":
                return 11;

            case "Q":
                return 12;

            case "K":
                return 13;

            case "A":
                return 14;

            default:
                return Integer.parseInt(cardNumber);

        }
    }

    private static int getType(char type) {

        switch (type) {
            case 'S':
                return 4;

            case 'H':
                return 3;

            case 'D':
                return 2;

            case 'C':
                return 1;
            default:
                return 0;
        }

    }
}
