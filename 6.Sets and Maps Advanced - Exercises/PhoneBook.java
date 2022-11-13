import java.util.*;

public class PhoneBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String,String> map = new HashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("search")){

            String name = input.split("\\-")[0];
            String number = input.split("\\-")[1];

            map.put(name,number);

            input=scanner.nextLine();
        }
        input = scanner.nextLine();

        while (!input.equals("stop")){

            String name = input;

            if(map.containsKey(name)){
                String num = map.get(name);
                System.out.printf("%s -> %s%n",name,num);
            }else {
                System.out.printf("Contact %s does not exist.%n",name);
            }

            input = scanner.nextLine();
        }

    }
}
