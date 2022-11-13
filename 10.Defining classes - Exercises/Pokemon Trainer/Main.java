import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        Map<String, Trainer> trainerMap = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("Tournament")) {

            String[] tokens = input.split("\\s+");

            String trainerName = tokens[0];
            String pokemonName = tokens[1];
            String element = tokens[2];
            int health = Integer.parseInt(tokens[3]);

            Pokemon pokemon = new Pokemon(pokemonName, element, health);
            Trainer trainer = new Trainer(trainerName, pokemon);
            if (trainerMap.containsKey(trainerName)) {
                trainerMap.get(trainerName).getPokemonList().add(pokemon);
                int num = trainerMap.get(trainerName).getNumPoke();
                num+=1;
                trainerMap.get(trainerName).setNumPoke(num);
            } else {
                trainerMap.put(trainerName, trainer);
            }


            input = scanner.nextLine();
        }

        input = scanner.nextLine();

        while (!input.equals("End")) {

            switch (input) {
                case "Fire":
                    trainerMap.forEach((a, b) -> {
                        if (b.checkElement("Fire")) {
                            b.setWin();
                        } else {
                            b.setLoss();
                        }
                    });
                    break;
                case "Water":
                    trainerMap.forEach((a, b) -> {
                        if (b.checkElement("Water")) {
                            b.setWin();
                        } else {
                            b.setLoss();
                        }
                    });

                    break;
                case "Electricity":
                    trainerMap.forEach((a, b) -> {
                        if (b.checkElement("Electricity")) {
                            b.setWin();
                        } else {
                            b.setLoss();
                        }
                    });

                    break;

            }
            input = scanner.nextLine();
        }

        trainerMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.comparingInt(Trainer::getBadges).reversed()))
                .filter(e -> e.getValue().checkHealth())
                .forEach(e -> System.out.println(e.getValue()));


    }
}