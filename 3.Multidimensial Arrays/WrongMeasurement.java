import java.util.*;

public class WrongMeasurement {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[n][];

        for (int i = 0; i < n; i++) {

            int[] arr = Arrays
                    .stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            matrix[i] = arr;
        }
        int[][] resultMatrix = new int[n][matrix[n - 1].length];

        String[] input = scanner.nextLine().split(" ");

        int iIndex = Integer.parseInt(input[0]);
        int jIndex = Integer.parseInt(input[1]);

        int value = matrix[iIndex][jIndex];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == value) {
                    int sum = 0;
                    boolean allAreValue = true;
                    if (i + 1 < n && matrix[i + 1][j] != value) {
                        sum += matrix[i + 1][j];
                        allAreValue = false;
                    }
                    if (i - 1 >= 0 && matrix[i - 1][j] != value) {

                        sum += matrix[i - 1][j];
                        allAreValue = false;
                    }
                    if (j + 1 < matrix[i].length && matrix[i][j + 1] != value) {
                        sum += matrix[i][j + 1];
                        allAreValue = false;
                    }
                    if (j - 1 >= 0 && matrix[i][j - 1] != value) {
                        sum += matrix[i][j - 1];
                        allAreValue = false;
                    }
                    if (!allAreValue) {
                        resultMatrix[i][j] = sum;

                    }
                    continue;
                }
                resultMatrix[i][j] = matrix[i][j];
            }
        }
        for (int[] a : resultMatrix) {
            for (int num : a) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

    }
}
