import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Car> carList = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {

            String[] tokens = scanner.nextLine().split("\\s+");

            String model = tokens[0];

            int engineSpeed = Integer.parseInt(tokens[1]);
            int enginePower = Integer.parseInt(tokens[2]);

            Engine currentEngine = new Engine(engineSpeed, enginePower);

            int cargoWeight = Integer.parseInt(tokens[3]);
            String cargoType = tokens[4];

            Cargo currentCargo = new Cargo(cargoWeight, cargoType);

            List<Tire> tireList = new ArrayList<>();

            for (int i = 5; i < tokens.length - 1; i += 2) {

                double tirePressure = Double.parseDouble(tokens[i]);
                int tireAge = Integer.parseInt(tokens[i + 1]);

                Tire tire = new Tire(tirePressure, tireAge);
                tireList.add(tire);
            }

            Car currentCar = new Car(model, currentEngine, currentCargo, tireList);

            carList.add(currentCar);

        }

        String input = scanner.nextLine();

        if (input.equals("fragile")) {
            carList.stream()
                    .filter(car -> car.getCargo().getType().equals("fragile"))
                    .filter(car -> car.getTireList().stream().anyMatch(tire -> tire.getPressure() < 1))
                    .forEach(car -> System.out.println(car.getModel()));
        } else {

            carList.stream()
                    .filter(car -> car.getCargo().getType().equals("flamable"))
                    .filter(e -> e.getEngine().getEnginePower() > 250)
                    .forEach(car-> System.out.println(car.getModel()));

        }

    }
}