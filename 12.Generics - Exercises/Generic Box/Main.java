import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Box box = new Box();

        while (n-->0){
            box.add(scanner.nextLine());
        }
        System.out.println(box);
    }
}