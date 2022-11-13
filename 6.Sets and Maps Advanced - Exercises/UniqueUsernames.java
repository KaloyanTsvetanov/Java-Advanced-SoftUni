import java.util.*;

public class UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Set<String> set = new LinkedHashSet<>();
        while (n-->0) {
            set.add(scanner.nextLine());
        }
        for(var a :set){
            System.out.println(a);
        }
    }
}
