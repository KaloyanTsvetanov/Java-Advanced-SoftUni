import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> males = new ArrayDeque<>();
        ArrayDeque<Integer> females = new ArrayDeque<>();

        String[] tokens = scanner.nextLine().split("\\s+");

        for (String token : tokens) {
            males.push(Integer.parseInt(token));
        }
        tokens = scanner.nextLine().split("\\s+");

        for (String token : tokens) {
            females.offer(Integer.parseInt(token));
        }

        int matches = 0;

        while (!males.isEmpty() && !females.isEmpty()) {
            int lastMale = males.peek();
            int firstFemale = females.peek();
            if (lastMale <= 0) {
                males.pop();
                continue;
            }else if(lastMale%25==0){
                males.pop();
                males.pop();
                continue;
            }
            if (firstFemale <= 0) {
                females.poll();
                continue;
            }else if(firstFemale%25==0){
                females.poll();
                females.poll();
                continue;
            }
            if (lastMale == firstFemale) {
                matches++;
                males.pop();
                females.poll();
            } else {
                females.poll();
                int currentMale = males.pop();
                currentMale -= 2;
                males.push(currentMale);
            }

        }
        System.out.printf("Matches: %d%n",matches);
        System.out.print("Males left: ");
        if(!males.isEmpty()){
            List<String> result = new ArrayList<>();
            for (Integer male : males) {
                result.add(male.toString());
            }
            System.out.print(String.join(", ", result));
        }else {
            System.out.print("none");
        }
        System.out.println();
        System.out.print("Females left: ");
        if(!females.isEmpty()){
            List<String> result = new ArrayList<>();
            for (Integer female : females) {
                result.add(female.toString());
            }
            System.out.print(String.join(", ", result));
        }else {
            System.out.print("none");
        }
    }
}
