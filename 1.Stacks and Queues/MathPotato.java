import java.util.*;

public class MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        ArrayDeque<String> firstDeck = new ArrayDeque<>();
        for (String n : input){
            firstDeck.offer(n);
        }

        int n = Integer.parseInt(scanner.nextLine());
        int p =0;
        while (firstDeck.size()!=1){
            p++;
            int k = isPrime(p);
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
                if(i!=0 && i!=1) {

                }
            }
            if(k>2 || p==1) {
                System.out.printf("Removed %s%n", name);
            }else {
                firstDeck.push(name);
                System.out.printf("Prime %s%n",name);
            }

        }
        System.out.printf("Last is %s",firstDeck.poll());

    }
    public static int isPrime(int n){
        int counter =0;
        for (int i = 1; i <= n; i++) {
            if(n%i==0){
                counter++;
            }
        }
        return counter;
    }
}
