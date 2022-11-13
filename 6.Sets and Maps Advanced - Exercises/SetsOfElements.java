import java.util.*;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int firstNumber = Integer.parseInt(input.split("\\s+")[0]);
        int secondNumber = Integer.parseInt(input.split("\\s+")[1]);

        Set<String> setFirst = new LinkedHashSet<>();
        Set<String> setSecond = new LinkedHashSet<>();

        while (firstNumber-->0){
            input=scanner.nextLine();
            setFirst.add(input);
        }

        while (secondNumber-->0){
            input = scanner.nextLine();
            setSecond.add(input);
        }
        setFirst.retainAll(setSecond);

        System.out.print(String.join(" ",setFirst));

    }
}
