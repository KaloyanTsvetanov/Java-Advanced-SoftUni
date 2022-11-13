import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> licensePlate = new ArrayDeque<>();
        ArrayDeque<Integer> cars = new ArrayDeque<>();

        int numberOfDays = 0;
        int numberOfCars = 0;

        String[] tokens = scanner.nextLine().split(", ");

        for (String token : tokens) {
            licensePlate.offer(Integer.parseInt(token));
        }

        tokens = scanner.nextLine().split(", ");

        for (String token : tokens) {
            cars.push(Integer.parseInt(token));
        }

        while (!licensePlate.isEmpty() && !cars.isEmpty()) {

            int firstPlates = licensePlate.peek();
            int lastCars = cars.peek();

            if (firstPlates > 2 * lastCars) {
                numberOfCars += lastCars;
                int a = licensePlate.pop();
                a -= lastCars * 2;
                licensePlate.offer(a);
                cars.pop();
            } else if (firstPlates == 2 * lastCars) {
                numberOfCars += lastCars;
                cars.pop();
                licensePlate.poll();
            } else {
               int a = lastCars - firstPlates / 2;
               numberOfCars+=(firstPlates/2);
               licensePlate.poll();
               cars.pop();
               cars.offer(a);
            }

            numberOfDays++;

        }

        System.out.printf("%d cars were registered for %d days!%n",numberOfCars,numberOfDays);
            if(!licensePlate.isEmpty()){
                int sum = 0;
                for (Integer integer : licensePlate) {
                    sum+=integer;
                }
                System.out.printf("%d license plates remain!%n",sum);
            }else if(!cars.isEmpty()){
                int sum = 0;
                for (Integer integer : cars) {
                    sum+=integer;
                }
                System.out.printf("%d cars remain without license plates!%n",sum);
            }else {
                System.out.println("Good job! There is no queue in front of the KAT!");
            }
    }
}

