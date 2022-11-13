import java.util.*;

public class DiagonalDifference {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int sumFirst = 0;
        int sumSecond = 0;

        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            int[] arr = Arrays
                    .stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[i] = arr;

        }

        int p =n-1;
        for (int i = 0; i < n; i++) {
            sumFirst+=matrix[i][i];
            sumSecond+=matrix[i][p];
            p--;
        }
        System.out.println(Math.abs(sumFirst-sumSecond));
    }
}
