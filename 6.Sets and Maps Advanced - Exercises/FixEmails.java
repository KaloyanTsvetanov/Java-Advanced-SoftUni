import java.util.*;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String,String> map = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("stop")){

            String name = input;
            input = scanner.nextLine();
            String email = input;
            if(!email.contains("com") && !email.contains("us") && !email.contains("uk")){
                map.put(name,email);
            }

            input = scanner.nextLine();
        }

        map.forEach((e,k)->{
            System.out.printf("%s -> %s%n",e,k);
        });

    }
}
