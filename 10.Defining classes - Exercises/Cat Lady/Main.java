import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Cat> catList = new ArrayList<>();
        String input = scanner.nextLine();

        while (!input.equals("End")){

            String [] tokens = input.split("\\s+");
            String breed = tokens[0];
            String name = tokens[1];
            Double information = Double.parseDouble(tokens[2]);
            Cat cat = new Cat(breed,name,information);

            catList.add(cat);

            input= scanner.nextLine();
        }
        input = scanner.nextLine();
        String name = input;
        catList.stream().filter(e -> e.getName().equals(name)).forEach(a-> System.out.println(a.toString()));
    }
}