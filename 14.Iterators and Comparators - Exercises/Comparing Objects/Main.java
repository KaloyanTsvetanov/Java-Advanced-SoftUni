import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Person> personList = new ArrayList<>();

        while (!input.equals("END")){

            String[] tokens = input.split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            String city = tokens[2];

            Person person = new Person(name,age,city);
            personList.add(person);


            input = scanner.nextLine();
        }

        int compareIndex = Integer.parseInt(scanner.nextLine());
        Person comparePerson = personList.get(compareIndex-1);

        int total = personList.size();
        int same = 0;
        int diff = 0;
        for (Person person : personList) {
            if(person.compareTo(comparePerson) == 0){
                same++;
            }else {
                diff++;
            }
        }

        if(same==1){
            System.out.println("No matches");
        }else {
            System.out.printf("%d %d %d",same,diff,total);
        }

    }
}