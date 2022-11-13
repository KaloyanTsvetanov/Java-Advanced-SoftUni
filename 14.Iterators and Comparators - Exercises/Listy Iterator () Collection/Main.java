import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ListyIterator listyIterator = null;
        while (!input.equals("END")) {

            String[] command = input.split("\\s+");
            String commandName = command[0];


            switch (commandName) {

                case "Create":
                    if (command.length > 1) {
                        listyIterator = new ListyIterator(Arrays.copyOfRange(command, 1, command.length));
                    } else {
                        listyIterator = new ListyIterator();
                    }
                    break;
                case "Move":
                    System.out.println(listyIterator.move());
                    break;
                case "Print":
                    try {
                        listyIterator.print();
                    } catch (IllegalStateException e) {
                        System.out.println("Invalid Operation!");
                    }
                    break;
                case "HasNext":
                    System.out.println(listyIterator.hasNext());
                    break;
                case "PrintAll":
                    for (String e : listyIterator) {
                        System.out.print(e+" ");
                    }
                    System.out.println();
                    break;

            }


            input = scanner.nextLine();
        }

    }
}