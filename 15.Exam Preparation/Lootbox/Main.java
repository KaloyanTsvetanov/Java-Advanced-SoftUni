import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> firstBox = new ArrayDeque<>();
        ArrayDeque<Integer> secondBox = new ArrayDeque<>();

        String[] tokens = scanner.nextLine().split("\\s+");
        for (String token : tokens) {
            firstBox.offer(Integer.parseInt(token));
        }
        tokens = scanner.nextLine().split("\\s+");
        for (String token : tokens) {
            secondBox.push(Integer.parseInt(token));
        }
        int collectionSum = 0;

        while (!firstBox.isEmpty() && !secondBox.isEmpty()){
            int firstNumber = firstBox.peek();
            int secondNumber = secondBox.peek();
            int sum = firstNumber+secondNumber;
            if(sum%2==0){
                collectionSum+=sum;
                firstBox.poll();
                secondBox.pop();
            }else {
                int a = secondBox.pop();
                firstBox.offer(a);
            }
        }
        if(firstBox.isEmpty()){
            System.out.println("First lootbox is empty");
        }else {
            System.out.println("Second lootbox is empty");
        }
        if(collectionSum>=100){
            System.out.printf("Your loot was epic! Value: %d",collectionSum);
        }else {
            System.out.printf("Your loot was poor... Value: %d",collectionSum);
        }

    }
}
