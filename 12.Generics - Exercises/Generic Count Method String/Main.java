import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Box<String> box = new Box<>();

        while (n-- > 0) {
            box.add(scanner.nextLine());
        }
        String  tokens = scanner.nextLine();

        int a = box.biggerElements(tokens);
        System.out.println(a);
    }
}