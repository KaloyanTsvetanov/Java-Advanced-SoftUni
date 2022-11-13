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
        String [] tokens = scanner.nextLine().split("\\s+");
        int fIndex = Integer.parseInt(tokens[0]);
        int sIndex = Integer.parseInt(tokens[1]);

        box.swat(fIndex,sIndex);
        System.out.println(box);
    }
}