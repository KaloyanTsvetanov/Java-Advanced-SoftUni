import java.util.*;

public class QueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        String input = scanner.nextLine();
        int n = Integer.parseInt(input.split(" ")[0]);
        int s = Integer.parseInt(input.split(" ")[1]);
        int x = Integer.parseInt(input.split(" ")[2]);
        input = scanner.nextLine();
        for (String num : input.split("\\s+")) {
            stack.offer(Integer.parseInt(num));
        }
        while (s > 0) {
            stack.poll();
            s--;
        }
        if (stack.isEmpty()) {
            System.out.println("0");
        } else {
            boolean isThere = false;
            int min = Integer.MAX_VALUE;
            for (int a : stack) {
                if (a < min) {
                    min = a;
                }
                if (a == x) {
                    isThere = true;
                }
            }
            if (isThere) {
                System.out.println("true");
            } else {
                System.out.println(min);
            }
        }

    }
}
