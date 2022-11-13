import java.util.*;

public class CitiesByContinent {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Map<String, List<String>>> map = new LinkedHashMap<>();

        while (n-- > 0) {

            String[] input = scanner.nextLine().split("\\s+");

            String continent = input[0];
            String country = input[1];
            String city = input[2];

            map.putIfAbsent(continent, new LinkedHashMap<>());
            Map<String, List<String>> countyWithCities = map.get(continent);
            countyWithCities.putIfAbsent(country, new ArrayList<>());
            List<String> cities = countyWithCities.get(country);
            cities.add(city);

        }
        map.forEach((continent, countryWithCities) -> {
            System.out.println(continent + ":");
            countryWithCities.forEach((key, value) -> System.out.println("  " + key + " -> " + String.join(", ", value)));
        });
    }
}
