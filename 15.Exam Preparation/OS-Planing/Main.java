import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> tasks = new ArrayDeque<>();
        ArrayDeque<Integer> threads = new ArrayDeque<>();

        String[] tokens = scanner.nextLine().split(", ");
        for (String token : tokens) {
            tasks.push(Integer.parseInt(token));
        }
        tokens = scanner.nextLine().split("\\s+");
        for (String token : tokens) {
            threads.offer(Integer.parseInt(token));
        }
        int kill = Integer.parseInt(scanner.nextLine());
        boolean killedTarget = false;
        int currentThread = 0;

        while (!tasks.isEmpty() && !threads.isEmpty() && !killedTarget) {
            int firstThread = threads.peek();
            int lastTask = tasks.peek();

            currentThread = threads.poll();
            if (firstThread < lastTask) {
                if (lastTask == kill) {
                    killedTarget = true;
                }
            }else {
                tasks.pop();
                if (lastTask == kill) {
                    killedTarget = true;
                }
            }

        }
        if (killedTarget) {
            System.out.printf("Thread with value %d killed task %d%n",currentThread,kill);
        }
        System.out.print(currentThread+ " ");
        for (Integer thread : threads) {
            System.out.print(thread+ " ");
        }
    }
}

