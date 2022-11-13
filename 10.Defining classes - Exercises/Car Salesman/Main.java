import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Set<Engine> engineSet = new HashSet<>();

        while (n-- > 0) {

            String[] tokens = scanner.nextLine().split("\\s+");

            String engineModel = tokens[0];
            int enginePower = Integer.parseInt(tokens[1]);

            Engine currentEngine = new Engine(engineModel, enginePower);

            if (tokens.length == 3) {
                String option = tokens[2];
                currentEngine = new Engine(engineModel, enginePower, option);
            } else if (tokens.length == 4) {
                String displace = tokens[2];
                String eff = tokens[3];
                currentEngine = new Engine(engineModel, enginePower, displace, eff);
            }

            engineSet.add(currentEngine);

        }

        List<Car> carList = new ArrayList<>();

        int m = Integer.parseInt(scanner.nextLine());

        while (m-- > 0){

            String[] tokens = scanner.nextLine().split("\\s+");

            String carModel = tokens[0];
            String engine = tokens[1];

            Engine engine1= engineSet.stream().filter(e->e.getModel().equals(engine)).findAny().get();

            Car currentCar = new Car(carModel,engine1);
            if(tokens.length==3){
                String option = tokens[2];
                currentCar = new Car(carModel,engine1,option);
            }else if(tokens.length==4){
                String weight = tokens[2];
                String color = tokens[3];
                currentCar = new Car(carModel,engine1,weight,color);
            }
            carList.add(currentCar);

        }
        carList.stream()
                .forEach(System.out::println);

    }
}