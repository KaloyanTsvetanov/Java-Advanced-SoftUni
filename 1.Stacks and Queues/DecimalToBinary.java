import java.util.*;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> deck = new ArrayDeque<>();
        int a = Integer.parseInt(scanner.nextLine());
        if (a == 0) {
            System.out.println(0);
        }
        while (a != 0) {
            deck.push(a % 2);
            a /= 2;
        }
        while (!deck.isEmpty()) {
            System.out.print(deck.pop());
        }
    }
}
