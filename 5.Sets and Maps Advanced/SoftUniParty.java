import java.util.*;

public class SoftUniParty {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Set<String> vip = new TreeSet<>();
        String input = scanner.nextLine();

        while (!input.equals("PARTY")){

            vip.add(input);

            input=scanner.nextLine();
        }
        input = scanner.nextLine();
        while (!input.equals("END")){

            vip.remove(input);

            input=scanner.nextLine();
        }
        System.out.println(vip.size());

        System.out.println(String.join(System.lineSeparator(),vip));
    }
}
