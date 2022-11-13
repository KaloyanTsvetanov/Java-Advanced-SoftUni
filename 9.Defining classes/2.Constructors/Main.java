import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            String[] input = scanner.nextLine().split("\\s+");

            Car car;

            if (input.length == 1) {
                car = new Car(input[0]);
            } else if (input.length == 2) {
                car = new Car(input[0], input[1]);
            } else car = new Car(input[0], input[1], Integer.parseInt(input[2]));

            System.out.println(car.carInfo());
        }

    }
}