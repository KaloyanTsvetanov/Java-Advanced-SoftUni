import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Car> cars = new LinkedHashMap<>();

        while (n-->0){

            String [] tokens = scanner.nextLine().split("\\s+");

            String model = tokens[0];
            double fuelAmount = Double.parseDouble(tokens[1]);
            double fuelConsumption = Double.parseDouble(tokens[2]);

            Car current = new Car(model,fuelAmount,fuelConsumption);

            cars.put(model,current);

        }

        String input = scanner.nextLine();

        while (!input.equals("End")){

            String carModel = input.split("\\s+")[1];
            int distance = Integer.parseInt(input.split("\\s+")[2]);

            Car car = cars.get(carModel);

            car.travelDistance(distance);

            cars.put(carModel,car);

            input=scanner.nextLine();
        }

        cars.entrySet().stream()
                .forEach(e-> System.out.println(e.getValue().toString()));

    }
}