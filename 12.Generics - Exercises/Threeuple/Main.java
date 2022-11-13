import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        String firstName = input[0] + " " + input[1];
        String address = input[2];
        String city = input[3];

        Threeuple<String, String,String> tuple = new Threeuple<>(firstName, address,city);
        System.out.println(tuple);

        input = scanner.nextLine().split("\\s+");
        String name = input[0];
        int litres = Integer.parseInt(input[1]);
        String drunk;
        if(input[2].equals("drunk")){
            drunk = "true";
        }else drunk = "false";

        Threeuple<String, Integer,String> secondTuple = new Threeuple<>(name, litres,drunk);
        System.out.println(secondTuple);

        input = scanner.nextLine().split("\\s+");

        String name1 = input[0];
        double n = Double.parseDouble(input[1]);
        String bank = input[2];
        Threeuple<String,Double,String> tup = new Threeuple<>(name1,n,bank);
        System.out.println(tup);
    }
}