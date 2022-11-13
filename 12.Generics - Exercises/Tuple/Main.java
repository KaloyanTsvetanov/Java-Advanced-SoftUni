import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        String firstName = input[0] + " " + input[1];
        String address = input[2];

        Tuple<String, String> tuple = new Tuple<>(firstName, address);
        System.out.println(tuple);

        input = scanner.nextLine().split("\\s+");
        String name = input[0];
        int litres = Integer.parseInt(input[1]);
        Tuple<String, Integer> secondTuple = new Tuple<>(name, litres);
        System.out.println(secondTuple);

        input = scanner.nextLine().split("\\s+");

        int num = Integer.parseInt(input[0]);
        double n = Double.parseDouble(input[1]);
        Tuple<Integer,Double> tup = new Tuple<>(num,n);
        System.out.println(tup);
    }
}