import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> firstBox = new ArrayDeque<>();
        ArrayDeque<Integer> secondBox = new ArrayDeque<>();

        String[] tokens = scanner.nextLine().split("\\s+");

        int summedItems = 0;

        for (String token : tokens) {
            firstBox.offer(Integer.parseInt(token));
        }
        tokens = scanner.nextLine().split("\\s+");
        for (String token : tokens) {
            secondBox.push(Integer.parseInt(token));
        }

        while (!firstBox.isEmpty() && !secondBox.isEmpty()) {
            int firstItem = firstBox.peek();
            int lastItem = secondBox.peek();
            int sum = firstItem + lastItem;
            if (sum % 2 == 0) {
                summedItems += sum;
                firstBox.poll();
                secondBox.pop();
            }else {
                int a = secondBox.pop();
                firstBox.offer(a);
            }

        }
        if(firstBox.isEmpty()){
            System.out.println("First magic box is empty.");
        }else {
            System.out.println("Second magic box is empty.");
        }
        if(summedItems>=90){
            System.out.printf("Wow, your prey was epic! Value: %d",summedItems);
        }else {
            System.out.printf("Poor prey... Value: %d",summedItems);
        }
    }
}

