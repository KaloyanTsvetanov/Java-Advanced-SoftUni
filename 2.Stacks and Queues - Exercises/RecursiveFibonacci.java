import java.math.BigInteger;
import java.util.*;

public class RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int n = Integer.parseInt(scanner.nextLine());
        if (n == 1) {
            System.out.println(1);
            n = -2;
        }
        int first = 1;
        int second = 1;
        int next = 0;
        int counter = 0;
        while (n > 0 && counter <= 43) {
            counter++;
            n--;
            stack.push(first);
            next = first + second;
            first = second;
            second = next;
            int num = stack.pop();
            if (n == 1) {
                System.out.println(next);
            }

        }
        String nextA = String.valueOf(next);
        String firstA = String.valueOf(first);
        String secondA = String.valueOf(second);

        while (n > 0) {
            n--;
            BigInteger nextAA = new BigInteger(nextA);
            BigInteger firstAA = new BigInteger(firstA);
            BigInteger secondAA = new BigInteger(secondA);
            nextAA= nextAA.add(firstAA);
            nextA=nextAA.toString();
            firstA=secondAA.toString();
            secondA=nextAA.toString();
            if(n==1){
                System.out.println(nextAA);
            }
        }

    }
}
