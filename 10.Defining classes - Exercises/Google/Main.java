import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        Map<String,Person> personMap = new HashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("End")) {

            String[] tokens = input.split("\\s+");

            String personName = tokens[0];
            String command = tokens[1];
            personMap.putIfAbsent(personName,new Person());
            switch (command) {
                case "company":
                    String nameOfCompanyCurrent = tokens[2] + " " + tokens[3];
                    double salaryCurrent = Double.parseDouble(tokens[4]);

                    Company company = new Company(nameOfCompanyCurrent, salaryCurrent);
                    personMap.get(personName).setCompany(company);

                    break;
                case "car":

                    String carModelCurrent = tokens[2];
                    String carHorsePowerCurrent = tokens[3];

                    Car car = new Car(carModelCurrent, carHorsePowerCurrent);
                    personMap.get(personName).setCar(car);

                    break;
                case "pokemon":

                    String pokemonNameCurrent = tokens[2];
                    String pokemonElementCurrent = tokens[3];

                    Pokemon pokemon = new Pokemon(pokemonNameCurrent, pokemonElementCurrent);
                    personMap.get(personName).getPokemonList().add(pokemon);

                    break;
                case "parents":

                    String parentNameCurrent = tokens[2];
                    String parentDateOfBirthCurrent = tokens[3];

                    Parents parents = new Parents(parentNameCurrent, parentDateOfBirthCurrent);
                    personMap.get(personName).getParentsList().add(parents);

                    break;
                case "children":

                    String childNameCurrent = tokens[2];
                    String childDateOfBirthCurrent = tokens[3];

                    Children children = new Children(childNameCurrent, childDateOfBirthCurrent);
                    personMap.get(personName).getChildrenList().add(children);

                    break;

            }


            input = scanner.nextLine();
        }

        input = scanner.nextLine();
        System.out.println(input);

        System.out.println(personMap.get(input).toString());

    }
}