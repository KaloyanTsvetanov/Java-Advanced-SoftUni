import java.util.*;

public class MaximumSumSubMatrix {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        int m = Integer.parseInt(input.split("\\,\\s+")[0]);
        int n = Integer.parseInt(input.split("\\,\\s+")[1]);
        int[][] result = new int[2][2];
        int[][] firstMatrix = new int[m][n];

        for (int i = 0; i < m; i++) {
            int[] arr = Arrays
                    .stream(scanner.nextLine().split("\\, "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            firstMatrix[i] = arr;

        }
        int maxSum = 0;
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                int a = firstMatrix[i][j];
                int b = firstMatrix[i][j + 1];
                int c = firstMatrix[i + 1][j];
                int d = firstMatrix[i + 1][j + 1];
                int sum = a + b + c + d;
                if (sum > maxSum) {
                    maxSum = sum;
                    result[0][0] = a;
                    result[0][1] = b;
                    result[1][0] = c;
                    result[1][1] = d;
                }
            }
        }
        for (int [] k : result){
            for (int g : k){
                System.out.print(g+" ");
            }
            System.out.println();
        }
        System.out.println(maxSum);

    }
}
