import java.util.*;

public class HotPotatoe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        ArrayDeque<String> firstDeck = new ArrayDeque<>();
        for (String n : input){
            firstDeck.offer(n);
        }

        int n = Integer.parseInt(scanner.nextLine());
        while (firstDeck.size()!=1){
            int m = n;
            while (m> firstDeck.size()){
                m-= firstDeck.size();
            }
            String name = "";
            for (int i = 0; i < m; i++) {
                name = firstDeck.poll();
                if(i!=m-1) {
                    firstDeck.offer(name);
                }
            }
            System.out.printf("Removed %s%n",name);

        }
        System.out.printf("Last is %s",firstDeck.poll());
    }
}
