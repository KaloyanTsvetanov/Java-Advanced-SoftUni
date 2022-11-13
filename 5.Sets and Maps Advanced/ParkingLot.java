import java.util.*;

public class ParkingLot {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        HashSet<String> cars = new LinkedHashSet<>();

        String input=scanner.nextLine();

        while (!input.equals("END")){

            String command = input.split("\\,\\s+")[0];
            String carNumber = input.split("\\,\\s+")[1];

            switch (command){
                case "IN":cars.add(carNumber);
                    break;
                case "OUT":cars.remove(carNumber);
                    break;
            }

            input=scanner.nextLine();
        }
        if(cars.isEmpty()){
            System.out.println("Parking Lot is Empty");
        }else {
            System.out.println(String.join(System.lineSeparator(), cars));
        }

    }
}
