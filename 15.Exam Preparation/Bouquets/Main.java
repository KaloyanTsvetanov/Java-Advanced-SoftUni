import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> daffodils = new ArrayDeque<>();
        ArrayDeque<Integer> tulips = new ArrayDeque<>();

        String[] tokens = scanner.nextLine().split(", ");
        for (String token : tokens) {
            daffodils.offer(Integer.parseInt(token));
        }
        tokens = scanner.nextLine().split(", ");
        for (String token : tokens) {
            tulips.push(Integer.parseInt(token));
        }
        int bouquets = 0;
        int storedFlowers = 0;

        while (!daffodils.isEmpty() && !tulips.isEmpty()) {
            int firstDaffodil = daffodils.peek();
            int lastTulip = tulips.peek();
            int sum = firstDaffodil + lastTulip;
            switch (sum) {
                case 15:
                    bouquets++;
                    daffodils.poll();
                    tulips.pop();
                    break;
                default:
                    if(sum>15){
                        int a = tulips.pop();
                        a-=2;
                        tulips.push(a);
                    }else {
                        storedFlowers+=sum;
                        daffodils.poll();
                        tulips.pop();
                    }
                    break;
            }

        }
        while (storedFlowers>15){
            bouquets++;
            storedFlowers-=15;
        }
        if(bouquets>=5){
            System.out.printf("You made it! You go to the competition with %d bouquets!",bouquets);
        }else {
            System.out.printf("You failed... You need more %d bouquets.",5-bouquets);
        }
    }
}

