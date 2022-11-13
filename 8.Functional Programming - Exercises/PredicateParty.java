import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<String> guestsNames = Arrays
                .stream(input.split("\\s+"))
                .collect(Collectors.toList());

        input = scanner.nextLine();

        while (!input.equals("Party!")) {

            String[] commandsParts = input.split("\\s+");

            String command = commandsParts[0];
            Predicate<String> predicate = getPredicate(commandsParts);
            switch (command) {

                case "Remove":
                    guestsNames.removeIf(predicate);
                    break;
                case "Double":
                    ArrayList<String> list = new ArrayList<>();
                    guestsNames.stream().filter(predicate).forEach(list::add);
                    guestsNames.addAll(list);
                    break;

            }


            input = scanner.nextLine();
        }
        if(guestsNames.isEmpty()){
            System.out.println("Nobody is going to the party!");
        }else {
            System.out.println(guestsNames.stream().map(String::valueOf)
                    .sorted()
                    .collect(Collectors.joining(", ")) + " are going to the party!");
        }

    }

    public static Predicate<String> getPredicate(String[] commandsParts) {

        Predicate<String> predicate=null;

        String filterName = commandsParts[1];
        String filterCriteria = commandsParts[2];

        switch (filterName) {
            case "StartsWith":
                predicate = name -> name.startsWith(filterCriteria);
                break;
            case "EndsWith":
                predicate = name -> name.endsWith(filterCriteria);
                break;
            case "Length":
                predicate = name -> name.length() == Integer.parseInt(filterCriteria);
                break;
        }

        return predicate;
    }
}