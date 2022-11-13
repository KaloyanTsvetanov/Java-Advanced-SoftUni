import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CustomList<String> customList = new CustomList<>();
        String input = scanner.nextLine();

        while (!input.equals("END")) {
            String[] tokens = input.split("\\s+");

            String command = tokens[0];
            switch (command) {
                case "Add":
                    String element = tokens[1];
                    customList.add(element);
                    break;
                case "Remove":
                    int index = Integer.parseInt(tokens[1]);
                    customList.remove(index);

                    break;
                case "Contains":
                    String elementToSearch = tokens[1];
                    System.out.println(customList.contains(elementToSearch));
                    break;
                case "Swap":
                    int a = Integer.parseInt(tokens[1]);
                    int b = Integer.parseInt(tokens[2]);
                    customList.swap(a, b);

                    break;
                case "Count":
                    System.out.println(customList.count());

                    break;
                case "Greater":
                    String e = tokens[1];
                    System.out.println(customList.countGreater(e));
                    break;

                case "Min":
                    System.out.println(customList.min());
                    break;

                case "Max":
                    System.out.println(customList.max());
                    break;

                case "Print":
                    customList.print();
                    break;

                case "Sort":
                    customList.sort();
            }

            input = scanner.nextLine();

        }
    }
}