import java.util.*;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Double>> storeMap = new TreeMap<>();

        String input = scanner.nextLine();

        while (!input.equals("Revision")) {

            String currentStore = input.split("\\,\\s+")[0];
            String product = input.split("\\,\\s+")[1];
            double price = Double.parseDouble(input.split("\\,\\s+")[2]);

            storeMap.putIfAbsent(currentStore, new LinkedHashMap<>());
            storeMap.get(currentStore).putIfAbsent(product, price);

            input = scanner.nextLine();
        }
        storeMap.forEach((market, product) -> {
            System.out.println(market + "->");
            product.forEach((eat, price) -> {
                System.out.printf("Product: %s, Price: %.1f%n", eat, price);
            });
        });
    }
}
